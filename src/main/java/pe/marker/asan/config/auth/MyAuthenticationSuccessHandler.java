/*
package pe.marker.asan.config.auth;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private static final String REDIRECT_URI = "http://localhost:8080/oauth/loginInfo";
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
        AuthenticationSuccessHandler.super.onAuthenticationSuccess(request, response, chain, authentication);
        response.sendRedirect(UriComponentsBuilder.fromUriString(REDIRECT_URI)
                .queryParam("accessToken","accessToken")
                .queryParam("refreshToken","refreshToken")
                .build()
                .encode(StandardCharsets.UTF_8)
                .toUriString());
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.sendRedirect(UriComponentsBuilder.fromUriString(REDIRECT_URI)
                .queryParam("accessToken","accessToken")
                .queryParam("refreshToken","refreshToken")
                .build()
                .encode(StandardCharsets.UTF_8)
                .toUriString());
    }
}
*/
