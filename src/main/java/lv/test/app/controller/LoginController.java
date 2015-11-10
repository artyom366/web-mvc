package lv.test.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by artyom on 15.10.11.
 */

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String showLogin() {
        return "login";
    }
}
