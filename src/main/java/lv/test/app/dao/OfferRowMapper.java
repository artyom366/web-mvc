package lv.test.app.dao;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by artyom on 15.23.11.
 */
public class OfferRowMapper implements RowMapper<Offer> {


    @Override
    public Offer mapRow(ResultSet resultSet, int i) throws SQLException {

        Offer offer = new Offer();
        User user = new User();

        user.setAuthority(resultSet.getString("authority"));
        user.setEmail(resultSet.getString("email"));
        user.setEnabled(true);
        user.setName(resultSet.getString("name"));
        user.setUserName(resultSet.getString("username"));

        offer.setId(resultSet.getInt("id"));
        offer.setText(resultSet.getString("text"));
        offer.setUser(user);

        return offer;
    }
}
