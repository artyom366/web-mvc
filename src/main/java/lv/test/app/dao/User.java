package lv.test.app.dao;

import lv.test.app.validator.ValidEmail;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by artyom on 15.10.11.
 */
public class User {

    @NotBlank
    @Size(min = 8, max = 15)
    @Pattern(regexp = "^\\w{8,}$")
    private String userName;

    @NotBlank
    @Pattern(regexp = "^\\S+$")
    @Size(min = 8, max = 15)
    private String password;

    @Email
    private String email;
    private boolean enabled;
    private String authority;

    public User() {
    }

    public User(String userName, String password, String email, boolean enabled, String authority) {
        this.userName = userName;
        this.password = password;
        this.email = email;
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
