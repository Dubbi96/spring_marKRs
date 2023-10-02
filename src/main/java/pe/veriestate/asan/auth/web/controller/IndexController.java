package pe.marker.asan.auth.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.marker.asan.common.status.HttpMessage;
import pe.marker.asan.common.status.HttpStatusEnum;

import javax.servlet.http.HttpServlet;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Controller
@RequestMapping
@Slf4j
public class IndexController extends HttpServlet {
    @GetMapping("/")
    public ResponseEntity<?> oauthLoginInfo(Authentication authentication){
        HttpHeaders headers = new HttpHeaders();
        HttpMessage message = new HttpMessage();
        headers.setContentType(new MediaType("application","json", StandardCharsets.UTF_8));
        if(authentication == null){
            log.info("Authentication Undetected");
            return new ResponseEntity<>(message,headers, HttpStatus.BAD_REQUEST);
        }else {
            //oAuth2User.toString() 예시 : Name: [2346930276], Granted Authorities: [[USER]], User Attributes: [{id=2346930276, provider=kakao, name=김준우, email=bababoll@naver.com}]
            OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
            //attributes.toString() 예시 : {id=2346930276, provider=kakao, name=김준우, email=bababoll@naver.com}
            Map<String, Object> attributes = oAuth2User.getAttributes();
            log.info("attributes : " + attributes);
            log.info("oAuth2User : " + oAuth2User);
            message.setStatus(HttpStatusEnum.OK);
            message.setMessage("성공 코드");
            message.setData(attributes);
            return new ResponseEntity<>(message,headers,HttpStatus.OK);
        }
    }
    @GetMapping("/login")
    public String login() {
        log.error("login");
        return "oauth/oauth-login";
    }

    @GetMapping("/main")
    public String landing(){
        log.info("landing page");
        return "Landing";
    }
}
