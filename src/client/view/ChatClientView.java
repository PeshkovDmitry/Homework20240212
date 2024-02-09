package client.view;

import client.presenter.Presenter;

import javax.swing.*;
import java.awt.*;

public class ChatClientView extends JFrame implements View {

    private static final int HEIGHT = 300;
    private static final int WIDTH = 500;
    private static final int HORIZONTAL_POSITION = 100;
    private static final int VERTICAL_POSITION = 100;

    private Presenter presenter;
    private JTextArea textArea;
    private SettingsWindow settingsWindow;
    private SendMessagePanel sendMessagePanel;


    public ChatClientView() {

        setSize(WIDTH, HEIGHT);
        setLocation(HORIZONTAL_POSITION, VERTICAL_POSITION);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);
        setTitle("Chat client");

        settingsWindow = new SettingsWindow();
        textArea = new JTextArea();
        sendMessagePanel = new SendMessagePanel();
        add(settingsWindow, BorderLayout.NORTH);
        add(textArea);
        add(sendMessagePanel, BorderLayout.SOUTH);
        showSettingsWindow();
    }

    @Override
    public void showWindow() {
        setVisible(true);
    }

    @Override
    public void printMessage(String message) {
        textArea.append(message);
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showSettingsWindow() {
        settingsWindow.setVisible(true);
    }

    @Override
    public void hideSettingsWindow() {
        settingsWindow.setVisible(false);
    }


    private class SettingsWindow extends JPanel {

        public SettingsWindow() {
            super(new GridLayout(2,3));
            JTextField hostField = new JTextField("127.0.0.1");
            JTextField portField = new JTextField("8189");
            JTextField nickNameField = new JTextField("petya");
            JPasswordField passwordField = new JPasswordField("password");
            JButton loginButton = new JButton("login");
            loginButton.addActionListener(e -> {
                presenter.setHost(hostField.getText());
                presenter.setPort(portField.getText());
                presenter.setNickname(nickNameField.getText());
                presenter.setPassword(passwordField.getPassword());
                presenter.connect();
            });
            add(hostField);
            add(portField);
            add(new JPanel());
            add(nickNameField);
            add(passwordField);
            add(loginButton);
        }
    }

    private class SendMessagePanel extends JPanel{

        private JTextField newMessageField;

        public SendMessagePanel() {
            super(new GridLayout(1,2));
            newMessageField = new JTextField();
            newMessageField.addActionListener(e -> {
                sendMessage();
            });
            JButton sendButton = new JButton("send");
            sendButton.addActionListener(e -> {
                sendMessage();
            });
            add(newMessageField);
            add(sendButton);
        }

        private void sendMessage() {
            presenter.sendMessage(newMessageField.getText());
            newMessageField.setText("");
        }

    }

}
