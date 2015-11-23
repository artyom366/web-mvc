package lv.test.app.dao;

import lv.test.app.validator.ValidEmail;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by artyom on 15.10.11.
 */
public class User {

    @NotBlank()
    @Size(min = 8, max = 15)
    @Pattern(regexp = "^\\w{8,}$")
    private String userName;

    @NotBlank
    @Pattern(regexp = "^\\S+$")
    @Size(min = 8, max = 15)
    private String password;

    @Email
    private String email;

    @NotBlank
    @Size(min = 4, max = 25)
    private String name;
    private boolean enabled;
    private String authority;

    public User() {
    }

    public User(String userName, String password, String email, String name, boolean enabled, String authority) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.name = name;
        this.enabled = enabled;
        this.authority = authority;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
