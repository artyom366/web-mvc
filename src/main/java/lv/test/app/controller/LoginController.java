package lv.test.app.controller;

import lv.test.app.dao.FormValidationGroup;
import lv.test.app.dao.Offer;
import lv.test.app.dao.User;
import lv.test.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

/**
 * Created by artyom on 15.10.11.
 */

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String showLogin() {
        return "login";
    }

    @RequestMapping("/loggedout")
    public String showLogoff() {
        return "loggedout";
    }

    @RequestMapping("/denied")
    public String showDenied() {
        return "denied";
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

    @RequestMapping(value = "/createaccount", method = RequestMethod.POST)
    public String doCreateAccount(@Validated(FormValidationGroup.class) User user, BindingResult result) {

        if (result.hasErrors()) {
            return "newacc";

        } else if (userService.exists(user.getUserName())) {

            result.rejectValue("userName", "DuplicateKey.user.userName");
            return "newacc";
        }

        user.setEnabled(true);
        user.setAuthority("ROLE_USER");

        userService.create(user);

        return "accountcreated";
    }

    @RequestMapping(value = "/admin")
    public String admin(Locale locale, Model model) {

        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);

        System.out.println(locale);
        return "admin";
    }



}
