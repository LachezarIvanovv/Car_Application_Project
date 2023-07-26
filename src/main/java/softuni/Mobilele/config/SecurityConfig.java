package softuni.Mobilele.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import softuni.Mobilele.model.enums.UserRoleEnum;
import softuni.Mobilele.model.service.MobileleUserDetailsService;
import softuni.Mobilele.model.service.OauthSuccessHandler;
import softuni.Mobilele.repository.UserRepository;

@Configuration
public class SecurityConfig {

    //Here we have to expose 3 things:
    // 1. PasswordEncoder
    // 2. SecurityFilterChain
    // 3. UserDetailsService

    @Bean
    public PasswordEncoder passwordEncoder(){
//        return new Pbkdf2PasswordEncoder();
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http,
                                           OauthSuccessHandler oauthSuccessHandler) throws Exception {

        http.
                // define which requests are allowed and which not
                        authorizeHttpRequests().
                // everyone can download static resources (css, js, images)
                        requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll().
                // everyone can log in and register
                        requestMatchers("/", "/users/login", "/users/register", "/offers/**",
                        "/search").permitAll().
                // pages available only for moderators
//                        requestMatchers("/pages/moderators").hasRole(UserRoleEnum.MODERATOR.name()).
                // pages available only for admins
                        requestMatchers("/pages/admins").hasRole(UserRoleEnum.ADMIN.name()).
                // all other pages are available for logger in users
                        anyRequest().
                authenticated().
                and().
                // configuration of form login
                        formLogin().
                // the custom login form
                        loginPage("/users/login").
                // the name of the username form field
                        usernameParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY).
                // the name of the password form field
                        passwordParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_PASSWORD_KEY).
                // where to go in case that the login is successful
                        defaultSuccessUrl("/").
                // where to go in case that the login failed
                        failureForwardUrl("/users/login-error").
                and().
                // configure logout
                        logout().
                // which is the logout url
                        logoutUrl("/users/logout").
                // on logout go to home page
                        logoutSuccessUrl("/").
                // invalidate the session and delete the cookies
                        invalidateHttpSession(true).
                    deleteCookies("JSESSIONID")
                .and()
                // allow oauth login
                .oauth2Login()
                .loginPage("/users/login")
                .successHandler(oauthSuccessHandler);


        return http.build();
    }


    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository){
        return new MobileleUserDetailsService(userRepository);
    }
}
