package lv.test.app.service;

import lv.test.app.dao.Offer;
import lv.test.app.dao.OffersDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by artyom on 15.4.11.
 */

@Service
public class OfferService {

    @Autowired
    private OffersDAO offersDAO;

    public List<Offer> getCurrent() {
        return offersDAO.getOffers();
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public boolean create(Offer offer) {
        return offersDAO.create(offer);
    }

    public Offer throwTestException() {
        return offersDAO.getOffer(999);
    }

    public boolean hasOffer(String userName) {

        List<Offer> offers = offersDAO.getOffers(userName);

        if (offers.size() > 0) {
            return true;
        }

        return false;
    }

    public Offer getOffer(String userName) {

        List<Offer> offers = offersDAO.getOffers(userName);

        if (offers.size() == 0) {
            return null;
        }

        return offers.get(0);
    }

    public void saveOrUpdate(Offer offer) {

        if (offer.getId() != 0) {
            offersDAO.update(offer);
        } else {
            offersDAO.create(offer);
        }

    }

    public boolean delete(int id) {
        return offersDAO.delete(id);
    }
}
