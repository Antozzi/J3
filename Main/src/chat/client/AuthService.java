package chat.client;

import java.sql.*;

public class AuthService {

    private Connection connection;

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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean checkUser(String user, char[] pass) {
        start();

        try {
            PreparedStatement selectUser = connection.prepareStatement("SELECT Password FROM users WHERE login = ?");
            PreparedStatement updateLoggedInUser = connection.prepareStatement("UPDATE users set loggedin = 1 WHERE login = ?");
            selectUser.setString(1, user);
            ResultSet password = selectUser.executeQuery();
            if (password.next()) {
                String checkpass = new String(pass);
                String passForCheck = password.getString("Password");
                if (passForCheck.equals(checkpass)) {
                    updateLoggedInUser.setString(1, user);
                    updateLoggedInUser.executeUpdate();
                    //connection.commit();
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
            //connection.commit();
            close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
