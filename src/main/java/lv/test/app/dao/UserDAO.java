package lv.test.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component("userDao")
public class UserDAO {

	private NamedParameterJdbcTemplate jdbc;

	public UserDAO() {
		System.out.println("--------------------------------------------------------------------------------------------Loaded DAO");
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	@Transactional
	public boolean create(User user) {

		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);

		jdbc.update("insert into users (username, password, email, enabled) values (:userName, :password, :email, :enabled)", params);
		return jdbc.update("insert into authorities (username, authority) values (:userName, :authority)", params) == 1;
	}

	public boolean exists(String userName) {

		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("username", userName);

		return jdbc.queryForObject("select count(*) from users where username =:username", mapSqlParameterSource, Integer.class) > 0;
	}



}
