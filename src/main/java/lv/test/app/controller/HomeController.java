package lv.test.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

/**
 * Created by artyom on 15.2.11.
 */

@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String home(Locale locale) {

        System.out.println(locale);
        System.out.println(Locale.forLanguageTag("LV-lv"));
        return "home";
    }
}
