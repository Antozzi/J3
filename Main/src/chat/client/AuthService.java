package chat.client;

import java.sql.*;
import java.util.Arrays;

public class AuthService {

    private static Connection connection = null;

    private void start() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:C:/SQLite/chat_db.db");
        } catch (Exception e) {
            System.out.println("Database not found");
            e.printStackTrace();
        }
    }

    private void close() {
        try {
            connection.close();
            connection = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean checkUser(String user, char[] pass) {
        Statement stmt;
        start();
        try {
            stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT Password FROM users WHERE login = '" + user + "'");
            if (resultSet.next()) {
                String checkpass = new String(pass);
                String passForCheck = resultSet.getString("Password");
                if (passForCheck.equals(checkpass)) {
                    stmt.executeUpdate("UPDATE users set loggedin = 1 WHERE login = '" + user + "'");
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            close();
        }
        return false;
    }

    public void swapNickname(String user, String loginForChange) {
        Statement stmt;

        start();

        try {
            stmt = connection.createStatement();
            int result = stmt.executeUpdate("UPDATE users set loggedin = 1 WHERE login = '" + user + "'");
            close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
