package chat.client;


import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        while (!new AuthService().checkUser(LoginWindow.user, LoginWindow.pass)) {
            new LoginWindow();
        }
        new ClientWindow();

    }
}
