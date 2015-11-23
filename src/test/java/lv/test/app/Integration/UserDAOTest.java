package lv.test.app.Integration;

import static org.junit.Assert.*;

import lv.test.app.dao.User;
import lv.test.app.dao.UserDAO;
import org.junit.Before;
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

    @Before
    public void init() {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        jdbcTemplate.execute("DELETE FROM users");
        jdbcTemplate.execute("DELETE FROM authorities");

        user = new User("testUserName", "testPassword", "test@email.lv", true, "ROLE_USER");
    }


    @Test
    public void test() {
        assertEquals("Test", 1, 1);

        assertTrue(userDAO.create(user));
    }
}
