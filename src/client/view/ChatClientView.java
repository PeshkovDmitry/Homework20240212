package client.view;

import javax.swing.*;
import java.awt.*;

public class ChatClientView extends JFrame implements View {

    private static final int HEIGHT = 300;
    private static final int WIDTH = 500;
    private static final int HORIZONTAL_POSITION = 100;
    private static final int VERTICAL_POSITION = 100;
    private int SEND_BUTTON_WIDTH = 100;
    private int SEND_BUTTON_HEIGHT = 30;

    public ChatClientView() {
        setSize(WIDTH, HEIGHT);
        setLocation(HORIZONTAL_POSITION, VERTICAL_POSITION);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setResizable(false);
        SettingsWindow settingsWindow = new SettingsWindow();
        JTextArea textArea = new JTextArea();
        SendMessagePanel sendMessagePanel = new SendMessagePanel();
        add(settingsWindow, BorderLayout.NORTH);
        add(textArea);
        add(sendMessagePanel, BorderLayout.SOUTH);
    }

    @Override
    public void showWindow() {
        setVisible(true);
    }

    @Override
    public void printMessage(String message) {

    }


    private class SettingsWindow extends JPanel {

        private String host;
        private Integer port;
        private String nickName;
        private String password;

        public SettingsWindow() {
            super(new GridLayout(2,3));
            JTextField hostField = new JTextField("127.0.0.1");
            JTextField portField = new JTextField("8189");
            JTextField nickNameField = new JTextField("petya");
            JPasswordField passwordField = new JPasswordField("password");
            JButton loginButton = new JButton("login");
            add(hostField);
            add(portField);
            add(new JPanel());
            add(nickNameField);
            add(passwordField);
            add(loginButton);
        }

        public void show() {
            this.setVisible(true);
        }

        public void hide() {
            setVisible(false);
        }

        public String getHost() {
            return host;
        }

        public Integer getPort() {
            return port;
        }

        public String getNickName() {
            return nickName;
        }

        public String getPassword() {
            return password;
        }

    }

    private class SendMessagePanel extends JPanel{

        public SendMessagePanel() {
            JTextField newMessagePane = new JTextField();
            newMessagePane.setPreferredSize(new Dimension(WIDTH - SEND_BUTTON_WIDTH, SEND_BUTTON_HEIGHT));
            JButton sendButton = new JButton("send");
            sendButton.setPreferredSize(new Dimension(SEND_BUTTON_WIDTH, SEND_BUTTON_HEIGHT));
            add(newMessagePane);
            add(sendButton, BorderLayout.EAST);
        }

    }

}
