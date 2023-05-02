package pe.marker.asan.auth.application.reslover;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.MustBeInvokedByOverriders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import pe.marker.asan.auth.application.dto.SessionUser;
import pe.marker.asan.config.auth.LoginUser;

import javax.servlet.http.HttpSession;

@Component
@Slf4j
@RequiredArgsConstructor
public class LoginUserArgumentResolver implements HandlerMethodArgumentResolver {
    private final HttpSession httpSession;

    @Override
    public boolean supportsParameter(MethodParameter parameter){
        boolean isLoginUserAnnotation = parameter.getParameterAnnotation(LoginUser.class) != null;
        boolean isUserClass = SessionUser.class.equals(parameter.getParameterType());
        log.info("supportsParameter + isLoginUserAnnotation : " + isLoginUserAnnotation);
        log.info("supportsParameter + isUserClass : " + isUserClass);
        log.info("supportsParameter + what the fuck : " + parameter.getParameterName());
        return isLoginUserAnnotation && isUserClass;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        log.info("resolveArgument + attribute : " + httpSession.getAttribute("user"));
        return httpSession.getAttribute("user");
    }
}
