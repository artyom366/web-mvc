package lv.test.app.controller;

import lv.test.app.dao.Offer;
import lv.test.app.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.Reader;
import java.util.List;

/**
 * Created by artyom on 15.2.11.
 */

@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String home() {

        return "home";
    }
}
