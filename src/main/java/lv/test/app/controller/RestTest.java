package lv.test.app.controller;

import lv.test.app.dao.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by artyom on 15.13.11.
 */

@RestController
@RequestMapping(value = "/api")
public class RestTest {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public User ttestRestController() {
        return new User("testName", "testPass", "testEmail", "testName", true, "testAuthority");
    }
}
