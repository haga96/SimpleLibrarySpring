package domain;


import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class User {
    private String login;
    private String password;
    private Role role;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.role = Role.USER;
    }
}