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
        textArea.setEditable(false);
        add(textArea);
        JPanel buttonsPanel = new JPanel(new GridLayout(1,2));
        JButton startButton = new JButton("Start");
        startButton.addActionListener(e -> {
            presenter.start();
        });
        JButton stopButton = new JButton("Stop");
        stopButton.addActionListener(e -> {
            presenter.stop();
        });
        buttonsPanel.add(startButton);
        buttonsPanel.add(stopButton);
        add(buttonsPanel, BorderLayout.SOUTH);
    }

    @Override
    public void showWindow() {
        setVisible(true);
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void printMessage(String message) {
        if (textArea.getText().isEmpty()) {
            textArea.append(message);
        } else {
            textArea.append("\n\r" + message);
        }
    }
}
