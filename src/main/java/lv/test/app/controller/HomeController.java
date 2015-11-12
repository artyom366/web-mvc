package lv.test.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

import java.util.Locale;

/**
 * Created by artyom on 15.2.11.
 */

@Controller
public class HomeController {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @RequestMapping(value = "/")
    public String home(Locale locale) {

        ReloadableResourceBundleMessageSource resourceBundleMessageSource = (ReloadableResourceBundleMessageSource) webApplicationContext.getBean("messageSource");

        System.out.println(locale);
        return "home";
    }

    @RequestMapping(value = "/admin")
    public String admin(Locale locale) {


        System.out.println(locale);
        return "admin";
    }
}
