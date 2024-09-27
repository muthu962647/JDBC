package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class Main implements CommandLineRunner {

    @Value("${sql.url}")
    private String url;

    @Value("${sql.username}")
    private String uname;

    @Value("${sql.password}")
    private String pass;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws SQLException {

        try (Connection con = DriverManager.getConnection(url, uname, pass)) {
            UserDAO dao = new UserDAO(con);

            User user = new User(142, "muthu@gmail.com", "Muthu", "8s6w1hgsdzt0q0@M", 0, true, 0);

            int rowsInserted = dao.insertUser(user);

            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully.");
            } else {
                System.out.println("User insertion failed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
