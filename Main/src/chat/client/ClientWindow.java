package chat.client;

import chat.database.HistoryLogger;
import chat.network.TCPConnection;
import chat.network.TCPConnectionListener;
import chat.server.AuthService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ClientWindow extends JFrame implements ActionListener, TCPConnectionListener {

    private static final String IP_ADDRS = "192.168.0.103";
    private static final int PORT = 8189;

    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    private final String CHANGE_LOGIN = "Swap Nickname";

    private static final JTextArea log = new JTextArea();
    private static final JScrollPane scroll = new JScrollPane(log);
    private final JTextField fieldInput = new JTextField();
    private final JButton changeLogin = new JButton(CHANGE_LOGIN);
    private final JTextField fieldNickName;

    private static TCPConnection connection;

    public ClientWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setAlwaysOnTop(false);
        String TITLE = "Chat Application";
        setTitle(TITLE);

        fieldNickName = new JTextField(LoginWindow.user);
        fieldNickName.setEditable(false);
        JPanel panelTop = new JPanel(new GridLayout(1, 2));
        panelTop.add(fieldNickName);
        panelTop.add(changeLogin);

        changeLogin.addActionListener(this);
        add(panelTop, BorderLayout.NORTH);

        log.setEditable(false);
        log.setLineWrap(true);
        scroll.setBounds(10, 60, 780, 500);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(scroll, BorderLayout.CENTER);

        fieldInput.addActionListener(this);
        add(fieldInput, BorderLayout.SOUTH);

        setVisible(true);
        try {
            connection = new TCPConnection(this, IP_ADDRS, PORT);
        } catch (IOException e) {
            printMsg("Connection exception: " + e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == changeLogin) {
            ChangeLoginWindow changeLoginWindow = new ChangeLoginWindow();
            new AuthService().swapNickname(fieldNickName.getText(), changeLoginWindow.loginForChange);
            fieldNickName.setText(changeLoginWindow.loginForChange);
        }
        if (src == fieldInput) {
            assert fieldInput != null;
            String msg = fieldInput.getText();
            if (msg.equals("")) return;
            fieldInput.setText(null);
            connection.sendString(fieldNickName.getText() + ": " + msg);
            HistoryLogger.doLogWriter(msg);
        }
    }


    @Override
    public void onConnectionReady(TCPConnection tcpConnection) {
        printMsg("Connection ready...\n");
        printMsg("History Log:\n");
        HistoryLogger.doLogReader();
    }

    @Override
    public void onReceiveString(TCPConnection tcpConnection, String value) {
        printMsg(value);
    }

    @Override
    public void onDisconnect(TCPConnection tcpConnection) {
        printMsg("Connection close");
    }

    @Override
    public void onException(TCPConnection tcpConnection, Exception e) {
        printMsg("Connection exception: " + e);
    }

    public static synchronized void printMsg(String msg) {
        SwingUtilities.invokeLater(() -> {
            log.append(msg + "\n");
            log.setCaretPosition(log.getDocument().getLength());
            HistoryLogger.doLogWriter(msg);
        });
    }
}
