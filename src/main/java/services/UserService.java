package services;

import domain.Role;
import domain.User;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;

@Service
public class UserService {
    private Map<String, User> userMap;

    public UserService(Map<String, User> userMap) {
        this.userMap = Collections.singletonMap("user", new User("user", "user", Role.USER));
    }


    public User getUserByLogin(String login) throws Exception {
        if(userMap.containsKey(login)) {
            return userMap.get(login);
        }else{
            throw new Exception("User not found");
        }
    }
}
