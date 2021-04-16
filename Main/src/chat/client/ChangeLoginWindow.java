package chat.client;

import javax.swing.*;
import java.awt.*;

public class ChangeLoginWindow extends JFrame {

    public String loginForChange;
    private static final String TITLE = "Swap Nickname";

    public ChangeLoginWindow() {
        JPanel panel = new JPanel(new GridLayout(1, 1));
        panel.add(new JLabel("Another Nickname"));
        JTextField login = new JTextField();
        panel.add(login);
        setAlwaysOnTop(true);
        if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, panel, TITLE, JOptionPane.YES_NO_OPTION))
            loginForChange = login.getText();
    }
}
