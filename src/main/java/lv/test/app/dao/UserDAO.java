package lv.test.app.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Transactional //bind dao to hibernate session
@Component("userDao")
public class UserDAO {

	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private PasswordEncoder passwordEncoder;

    public Session session() {
        return sessionFactory.getCurrentSession();
    }

	public UserDAO() {
		System.out.println("--------------------------------------------------------------------------------------------Loaded DAO");
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	public boolean create(User user) {


		//BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("username", user.getUserName());
		params.addValue("password", passwordEncoder.encode(user.getPassword()));
		//params.addValue("password", user.getPassword());
		params.addValue("email", user.getEmail());
		params.addValue("name", user.getName());
		params.addValue("enabled", user.isEnabled());
		params.addValue("authority", user.getAuthority());

		return jdbc.update("insert into users (username, password, email, name, enabled, authority) values (:username, :password, :email, :name, :enabled, :authority )", params) == 1;
	}

	public boolean exists(String userName) {

		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("username", userName);

		return jdbc.queryForObject("select count(*) from users where username =:username", mapSqlParameterSource, Integer.class) > 0;
	}


	public List<User> getAllUsers() {

        return session().createQuery("from User").list();
		//return jdbc.query("select * from users", BeanPropertyRowMapper.newInstance(User.class));


	}
}
