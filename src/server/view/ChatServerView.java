package server.view;

import server.presenter.Presenter;

import javax.swing.*;
import java.awt.*;

public class ChatServerView extends JFrame implements View {

    private static final int HEIGHT = 300;
    private static final int WIDTH = 500;
    private static final int HORIZONTAL_POSITION = 600;
    private static final int VERTICAL_POSITION = 600;

    private Presenter presenter;

    private JTextArea textArea;

    public ChatServerView() {

        setSize(WIDTH, HEIGHT);
        setLocation(HORIZONTAL_POSITION, VERTICAL_POSITION);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Chat server");

        textArea = new JTextArea();
        add(textArea);
        JPanel buttonsPanel = new JPanel(new GridLayout(1,2));
        JButton startButton = new JButton("Start");
        JButton stopButton = new JButton("Stop");
        buttonsPanel.add(startButton);
        buttonsPanel.add(stopButton);
        add(buttonsPanel, BorderLayout.SOUTH);
    }

    @Override
    public void showWindow() {
        setVisible(true);
    }

    @Override
    public void printMessage(String message) {
        textArea.append(message);
    }
}
