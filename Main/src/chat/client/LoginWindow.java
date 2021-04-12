package chat.client;

import javax.swing.*;
import java.awt.*;

public class LoginWindow extends JFrame {

    public static String user = null;
    public static char[] pass = null;
    private static final String TITLE = "Authorization";

    public LoginWindow() {
        JPanel panel = new JPanel(new GridLayout(2, 2));
        panel.add(new JLabel("Login"));
        JTextField login = new JTextField();
        panel.add(login);
        panel.add(new JLabel("Password"));
        JPasswordField password = new JPasswordField();
        panel.add(password);
        if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, panel, TITLE, JOptionPane.YES_NO_OPTION)) {
            user = login.getText();
            pass = password.getPassword();
        } else {
            System.exit(0);
        }

    }

}
