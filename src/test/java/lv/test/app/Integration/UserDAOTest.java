package lv.test.app.Integration;

import static org.junit.Assert.*;

import lv.test.app.dao.User;
import lv.test.app.dao.UserDAO;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by artyom on 15.19.11.
 */

@ActiveProfiles("dev")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "file:src/main/webapp/WEB-INF/test-dao-config.xml",
        "file:src/main/webapp/WEB-INF/security-config.xml",
        "file:src/main/webapp/WEB-INF/dao-config.xml"
})
public class UserDAOTest {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private DataSource dataSource;

    private User user;

//    @BeforeClass
//    public void classInit() {
//
//    }

    @Before
    public void methodInit() {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.execute("DELETE FROM offers");
        jdbcTemplate.execute("DELETE FROM users");

        user = new User("testUserName", "testPassword", "test@email.lv", "testName", true, "ROLE_USER");
    }

    @Test
    public void userCreateTest() {

        userDAO.create(user);
        List<User> users = userDAO.getAllUsers();

        assertEquals(1 ,users.size());
        assertEquals(user.getUserName() ,users.get(0).getUserName());
    }


}
