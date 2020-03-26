package services;

import domain.User;
import lombok.SneakyThrows;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import utils.UserDetailsWrapper;

@Service
public class UserDetailsServiceWrapper implements UserDetailsService {

    private UserService userService;

    public UserDetailsServiceWrapper(UserService userService) {
        this.userService = userService;
    }

    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = null;
        try {
            user = userService.getUserByLogin(login);
        } catch (Exception e) {
            throw new UsernameNotFoundException("User not found");
        }
        return new UserDetailsWrapper(user);
    }
}
