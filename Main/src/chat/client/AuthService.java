package chat.client;

import chat.database.DBConn;

import java.sql.*;


public class AuthService {

    public boolean checkUser(String user, char[] pass) {
        DBConn.start();
        try {
            ResultSet resultSet = DBConn.getUserPwd(user);
            if (resultSet.next()) {
                String checkpass = new String(pass);
                String passForCheck = resultSet.getString("Password");
                if (passForCheck.equals(checkpass)) {
                    DBConn.loginUser(user);
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            DBConn.close();
        }
        return false;
    }

    public void swapNickname(String user, String loginForChange) {

        DBConn.start();

        try {
            DBConn.swapUser(user, loginForChange);
            DBConn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
