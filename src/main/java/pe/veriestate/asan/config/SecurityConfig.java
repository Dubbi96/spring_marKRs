package pe.veriestate.asan.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import pe.veriestate.asan.auth.application.service.VeriEstateOAuth2UserService;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig {

    private final VeriEstateOAuth2UserService veriEstateOAuth2UserService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests()
                .antMatchers("/Landing", "/resources/**", "/static/**", "/login").permitAll()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .and()
                .oauth2Login()
                .defaultSuccessUrl("/", true)
                .userInfoEndpoint()
                .userService(veriEstateOAuth2UserService);

        return http.build();
    }
}