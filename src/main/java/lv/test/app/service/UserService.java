package lv.test.app.service;

import lv.test.app.dao.Offer;
import lv.test.app.dao.OffersDAO;
import lv.test.app.dao.User;
import lv.test.app.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by artyom on 15.4.11.
 */

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public boolean create(User user) {
        return userDAO.create(user);
    }


    public boolean exists(String userName) {

        return userDAO.exists(userName);
    }

    @Secured("ROLE_ADMIN")
    public List<User> getAllUsers() {

        return userDAO.getAllUsers();
    }
}
