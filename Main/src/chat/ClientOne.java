package chat;


import chat.client.ClientWindow;
import chat.client.LoginWindow;
import chat.server.AuthService;

public class ClientOne {
    public static void main(String[] args) {
        while (!new AuthService().checkUser(LoginWindow.user, LoginWindow.pass)) {
            new LoginWindow();
        }
        new ClientWindow();

    }
}
