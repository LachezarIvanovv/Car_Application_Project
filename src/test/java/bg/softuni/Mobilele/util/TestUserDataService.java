package bg.softuni.Mobilele.util;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import softuni.Mobilele.model.user.MobileleUserDetails;

import java.util.Collections;

@Service
public class TestUserDataService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new MobileleUserDetails("topsecret",
                                                username,
                                                "Test",
                                                "user",
                                                Collections.emptyList());
    }
}
