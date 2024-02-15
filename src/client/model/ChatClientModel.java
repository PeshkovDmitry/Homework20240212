package client.model;

import client.presenter.Presenter;

import java.io.*;
import java.net.Socket;

public class ChatClientModel implements Model{

    private Socket socket;

    private Presenter presenter;

    private String currentMessage = "Initial message";

    private String oldMessage;

    @Override
    public boolean connect(String host, int port) {
        try {
            socket =  new Socket(host, port);
            presenter.printMessage("Вы успешно подключились!");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try (DataOutputStream oos = new DataOutputStream(socket.getOutputStream());
                         DataInputStream ois = new DataInputStream(socket.getInputStream())) {
                        while (true) {
                            String message = (currentMessage.equals(oldMessage)
                                    ? " "
                                    : currentMessage);
                            oldMessage = currentMessage;
                            oos.writeUTF(message);
                            oos.flush();
                            Thread.sleep(100);
                            String in = ois.readUTF();
                            presenter.printMessage(in);
                            Thread.sleep(100);
                        }
                    } catch (IOException | InterruptedException e) {
                        e.printStackTrace();
                        presenter.printMessage("Не удалось отправить сообщение");
                    }
                }
            }).start();


            return true;
        } catch (IOException e) {
            presenter.printMessage("Не удалось подключиться к серверу");
            return false;
        }
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void sendMessage(String message) {
        currentMessage = message;
    }

    @Override
    public String getFormattedMessage(String message, String nickName) {
        return nickName + ": " + message;
    }
}
