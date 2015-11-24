package lv.test.app.controller;

import lv.test.app.dao.Offer;
import lv.test.app.service.OfferService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

import java.security.Principal;
import java.util.List;
import java.util.Locale;

/**
 * Created by artyom on 15.2.11.
 */

@Controller
public class HomeController {

    private static Logger logger = Logger.getLogger(HomeController.class);

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private OfferService offerService;

    @RequestMapping(value = "/")
    public String home(Locale locale, Model model, Principal principal) {

        ReloadableResourceBundleMessageSource resourceBundleMessageSource = (ReloadableResourceBundleMessageSource) webApplicationContext.getBean("messageSource");

        System.out.println(locale);
        logger.info("Showing home page");

        List<Offer> offers = offerService.getCurrent();
        model.addAttribute("offers", offers);

        boolean hasOffer = false;
        if (principal != null) {
            hasOffer = offerService.hasOffer(principal.getName());
        }

        model.addAttribute("hasOffer", hasOffer);

        return "home";
    }

}
