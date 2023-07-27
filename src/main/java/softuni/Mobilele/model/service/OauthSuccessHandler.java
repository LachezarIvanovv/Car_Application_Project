package softuni.Mobilele.model.service;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class OauthSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private final UserService userService;

    public OauthSuccessHandler(UserService userService) {
        this.userService = userService;
        setDefaultTargetUrl("/");
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        if(authentication instanceof OAuth2AuthenticationToken oAuth2AuthenticationToken){
            var userEmail = oAuth2AuthenticationToken
                    .getPrincipal()
                    .getAttribute("email")
                    .toString();

            userService.createUserIfNotExists(userEmail);
            userService.login(userEmail);
        }

        super.onAuthenticationSuccess(request, response, authentication);
    }
}
