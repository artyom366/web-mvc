package lv.test.app.controller;

import lv.test.app.dao.Offer;
import lv.test.app.service.OfferService;
import lv.test.app.util.IMachine;
import lv.test.app.util.IUtil;
import lv.test.app.util.RRT;
import lv.test.app.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

/**
 * Created by artyom on 15.5.11.
 */
@Controller
public class OfferController {

    @Autowired
    private OfferService offerService;

    @Autowired
    private RRT rrt;

    @Autowired
    private IUtil util;

    @RequestMapping(value = "/offers")
    public String showOffers(Model model) {

        rrt.test();
        ((IMachine) rrt).start();

        util.doSmth(5);

        List<Offer> offers = offerService.getCurrent();

        model.addAttribute("offers", offers);
        return "offers";
    }

    @RequestMapping(value = "/createoffer")
    public String createOffer(Model model, Principal principal) {

        Offer offer = null;

        if (principal != null) {
            String userName = principal.getName();

            offer = offerService.getOffer(userName);
        }

        if (offer == null) {
            offer = new Offer();
        }

        model.addAttribute("offer", offer);
        return "createoffer";
    }

    @RequestMapping(value = "/docreate", method = RequestMethod.POST)
    public String doCreate(Model model,
                           @Valid Offer offer,
                           BindingResult result,
                           Principal principal,
                           @RequestParam(value = "delete", required = false) String delete) { //delete param might not present in the request

        if (result.hasErrors()) {
            return "createoffer";
        }

        if (delete == null) {
            System.out.println("delete is null");

            String userName = principal.getName();
            offer.getUser().setUserName(userName);

            offerService.saveOrUpdate(offer);
            //offerService.create(offer);

            return "offercreated";
        } else {
            System.out.println("delete is not null");

            offerService.delete(offer.getId());
        }

        return "offerdeleted";
    }


    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(Model model, @RequestParam("id") String id) {
        System.out.println("ID is:" + id);
        return "home";
    }
}
