package org.example;
import java.sql.*;


public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        String url = "jdbc:mysql://localhost:3306/trading";
        String uname = "root";
        String pass = "8s6w1zt0q0@M";
        String query = "INSERT INTO user (id, email, name, password, role, is_enabled) VALUES(?,?,?,?,?,?)";

        Connection con = DriverManager.getConnection(url,uname,pass);
        PreparedStatement pstd = con.prepareStatement(query);
        pstd.setLong(1,103);
        pstd.setString(2,"muthu@gmail.com");
        pstd.setString(3, "Muthu"); // Set name as String
        pstd.setString(4, "8s6w1zt0q0@M"); // Set password as String
        pstd.setInt(5, 0); // Set status as int
        pstd.setInt(6, 0); // Set role as int
        int rowsInserted = pstd.executeUpdate();


        if(rowsInserted > 0){
            System.out.println("A new user was inserted Successfully");
        }

        pstd.close();
        con.close();
    }
}
