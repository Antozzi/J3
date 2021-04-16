package chat.database;

import java.sql.*;

public class DBConn {

    private static Connection conn;

    public static Connection getConn() {
        return conn;
    }


    public static void start() {

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:C:/SQLite/chat_db.db");
        } catch (Exception e) {
            System.out.println("Database not found");
            e.printStackTrace();
        }
    }

    public static void close() {
        try {
            conn.close();
            conn = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static ResultSet getUserPwd (String user) throws SQLException {
        PreparedStatement selectPwd = conn.prepareStatement("SELECT Password from users WHERE login = ?");
        selectPwd.setString(1, user);
        return selectPwd.executeQuery();
    }
    public static void loginUser (String user) throws SQLException {
        PreparedStatement updateLoggedUser = conn.prepareStatement("UPDATE users set loggedin = 1 WHERE login = ?");
        updateLoggedUser.setString(1, user);
        updateLoggedUser.executeUpdate();
    }

    public static void swapUser (String user, String loginForChange) throws SQLException {
        PreparedStatement updateLoggedUser = conn.prepareStatement("UPDATE users set loggedin = 1 WHERE login = ?");
        PreparedStatement updateUnloggedUser = conn.prepareStatement("UPDATE users set loggedin = 0 WHERE login = ?");
        updateLoggedUser.setString(1, loginForChange);
        updateUnloggedUser.setString(1, user);
        updateLoggedUser.executeUpdate();
        updateUnloggedUser.executeUpdate();
    }
}
