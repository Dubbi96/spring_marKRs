package pe.veriestate.asan.auth.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import pe.veriestate.asan.auth.application.dto.MemberProfile;
import pe.veriestate.asan.auth.application.dto.OAuthCustomAttributes;
import pe.veriestate.asan.auth.domain.entity.VeriEstateUser;
import pe.veriestate.asan.auth.domain.repository.VeriEstateUserRepository;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class VeriEstateOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {
    private final VeriEstateUserRepository veriEstateUserRepository;
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2UserService delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest); // OAuth 서비스(kakao, google, naver)에서 가져온 유저 정보를 담고있음

        String registrationId = userRequest.getClientRegistration()
                .getRegistrationId(); // OAuth 서비스 이름(ex. kakao, naver, google)
        String userNameAttributeName = userRequest.getClientRegistration()
                .getProviderDetails()
                .getUserInfoEndpoint()
                .getUserNameAttributeName(); // OAuth 로그인 시 키(pk)가 되는 값
        Map<String, Object> attributes = oAuth2User.getAttributes(); // OAuth 서비스의 유저 정보들

        MemberProfile memberProfile = OAuthCustomAttributes.extract(registrationId, attributes); // registrationId에 따라 유저 정보를 통해 공통된 UserProfile 객체로 만들어 줌
        memberProfile.setProvider(registrationId);
        log.info(registrationId);

        VeriEstateUser member = saveOrUpdate(memberProfile);

        Map<String, Object> customAttribute = customAttribute(attributes, userNameAttributeName, memberProfile, registrationId);

        return new DefaultOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority("USER")),
                customAttribute,
                userNameAttributeName);
    }

    private VeriEstateUser saveOrUpdate(MemberProfile memberProfile){
        VeriEstateUser member = veriEstateUserRepository.findByEmailAndProvider(memberProfile.getEmail(), memberProfile.getProvider())
                .map(m -> m.update(memberProfile.getName(), memberProfile.getEmail(), memberProfile.getPicture()))
                // OAuth 서비스 사이트에서 유저 정보 변경이 있을 수 있기 때문에 우리 DB에도 update
                .orElse(memberProfile.toMember());

        return veriEstateUserRepository.save(member);
    }

    private Map customAttribute(Map attributes, String userNameAttributeName, MemberProfile memberProfile, String registrationId) {
        Map<String, Object> customAttribute = new LinkedHashMap<>();
        customAttribute.put(userNameAttributeName, attributes.get(userNameAttributeName));
        customAttribute.put("provider", registrationId);
        customAttribute.put("name", memberProfile.getName());
        customAttribute.put("email", memberProfile.getEmail());
        return customAttribute;
    }
}
