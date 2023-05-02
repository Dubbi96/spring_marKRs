package pe.marker.asan.auth.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pe.marker.asan.auth.application.dto.SessionUser;
import pe.marker.asan.config.auth.LoginUser;

@RequiredArgsConstructor
@Controller
@Slf4j
public class IndexController {

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        if(user != null){
            model.addAttribute("userName", user.getUsername());
            log.error(user.getUsername());
        }else{
            log.error("User is Null");
            return "redirect:/login";
        }
        log.info("google,naver");
        return "redirect:/index";
    }
}
