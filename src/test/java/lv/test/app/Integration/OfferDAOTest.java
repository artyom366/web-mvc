package lv.test.app.Integration;

import junit.framework.Assert;
import lv.test.app.dao.Offer;
import lv.test.app.dao.OffersDAO;
import lv.test.app.dao.User;
import lv.test.app.dao.UserDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by artyom on 15.23.11.
 */

@ActiveProfiles("dev")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "file:src/main/webapp/WEB-INF/test-dao-config.xml",
        "file:src/main/webapp/WEB-INF/security-config.xml",
        "file:src/main/webapp/WEB-INF/dao-config.xml"
})
public class OfferDAOTest {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private OffersDAO offersDAO;

    @Autowired
    private DataSource dataSource;

    private User user;
    private List<Offer> offers;

    @Before
    public void init() {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        jdbcTemplate.execute("DELETE FROM offers");
        jdbcTemplate.execute("DELETE FROM users");

        user = new User("testUserName", "testPassword", "test@email.lv", "testName", true, "ROLE_USER");

        offers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Offer offer = new Offer("test sample offer text: " + i, user);
            offers.add(offer);
        }

    }

    @Test
    public void createOffer() {

        assertTrue(userDAO.create(user));

        for (Offer offer : offers) {
            assertTrue(offersDAO.create(offer));
        }

        assertEquals(offers.size(), offersDAO.getOffers(user.getUserName()).size());
    }
}
