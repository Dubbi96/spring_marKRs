/*
package pe.veriestate.asan.config;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfigWebSecurityConfigAdapter extends WebSecurityConfigurerAdapter {
    private final VeriEstateOAuth2UserService veriEstateOAuth2UserService;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()//csrf 공격을 막아주는 옵션을 disalbe, rest api같은 경우에는 브라우저를 통해 request 받지 않기 때문에 해당 옵션을 꺼도 됩니다.
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests()
                    .antMatchers("/login","/resources/**","/static/**","/oauth2login").permitAll()
                    .anyRequest().permitAll()
                .and()
                .oauth2Login()
                    .loginPage("/oauth2login")
                .and()
                .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/") //logout 요청시 홈으로 이동 - 기본 logout url = "/logout"
                .and()
                .oauth2Login() //OAuth2 로그인 설정 시작점
                .defaultSuccessUrl("/", true) //OAuth2 성공시 redirect
                .userInfoEndpoint() //OAuth2 로그인 성공 이후 사용자 정보를 가져올 때 설정 담당
                .userService(veriEstateOAuth2UserService); //OAuth2 로그인 성공 시, 작업을 진행할 MemberService
    }
}
*/
