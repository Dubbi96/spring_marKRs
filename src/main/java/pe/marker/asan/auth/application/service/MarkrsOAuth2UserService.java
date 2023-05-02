package pe.marker.asan.auth.application.service;

import io.swagger.annotations.Scope;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import pe.marker.asan.auth.application.dto.OAuthAttributes;
import pe.marker.asan.auth.application.dto.SessionUser;
import pe.marker.asan.auth.domain.entity.MarkrsUser;
import pe.marker.asan.auth.domain.repository.MarkrsUserRepository;

import javax.servlet.http.HttpSession;
import java.util.Collections;

@Service
@Slf4j
@RequiredArgsConstructor
public class MarkrsOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {
    private final MarkrsUserRepository markrsUserRepository;
    private final HttpSession httpSession;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        log.info("oauth user : " + oAuth2User.getName());

        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        String userNameAttributeName = userRequest.getClientRegistration()
                .getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();

        OAuthAttributes attributes =
                OAuthAttributes.of(registrationId,userNameAttributeName,oAuth2User.getAttributes());

        MarkrsUser user = saveOrUpdate(attributes);

        if (httpSession != null) {
            httpSession.setAttribute("user",new SessionUser(user));
        }

        return new DefaultOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority(user.getRoleKey())),
                        attributes.getAttributes(),
                        attributes.getNameAttributeKey());
    }

    private MarkrsUser saveOrUpdate(OAuthAttributes attributes){
        MarkrsUser markrsUser = markrsUserRepository.findByEmail(attributes.getEmail())
                //이미 존재할 경우 username,picture update 실시
                .map(entity -> entity.update(attributes.getName(),attributes.getPicture()))
                //없을 경우 신규 아이디 등록
                .orElse(attributes.toEntity());
        return markrsUserRepository.save(markrsUser);
    }
}
