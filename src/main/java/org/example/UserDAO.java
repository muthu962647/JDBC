package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {

    String query = "INSERT INTO user (id, email, name, password, role, is_enabled, send_to) VALUES(?,?,?,?,?,?,?)";

    private Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    public int insertUser(User user) throws SQLException {
        PreparedStatement pstd = connection.prepareStatement(query);

        pstd.setLong(1, user.getId());
        pstd.setString(2, user.getEmail());
        pstd.setString(3, user.getName());
        pstd.setString(4, user.getPassword());
        pstd.setInt(5, user.getRole());
        pstd.setBoolean(6, user.isEnabled());
        pstd.setInt(7, user.getSendTo());

        return pstd.executeUpdate();
    }
}
