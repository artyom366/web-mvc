package lv.test.app.controller;

import lv.test.app.dao.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @RequestMapping("/newacc")
    public String showAccountForm(Model model) {

        //This adds the new User object into the model,
        // keyed by the word "user".
        // So then you can access the user objects in your JSPs,
        // or the form can use the object.
        model.addAttribute("user", new User());
        return "newacc";
    }

    @RequestMapping("/createaccount")
    public String doCreateAccount() {


        return "accountcreated";
    }


}
