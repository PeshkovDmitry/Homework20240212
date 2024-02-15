package client.model;

import client.presenter.Presenter;

import java.io.*;
import java.net.Socket;

public class ChatClientModel implements Model{

    private Socket socket;

    private Presenter presenter;

    @Override
    public boolean connect(String host, int port) {
        try {
            socket =  new Socket(host, port);
            presenter.printMessage("Вы успешно подключились!");
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
        try (
                DataOutputStream oos = new DataOutputStream(socket.getOutputStream());
                DataInputStream ois = new DataInputStream(socket.getInputStream())) {
            int i = 0;
            while (i < 5) {
                oos.writeUTF("clientCommand " + i);
                oos.flush();
                String in = ois.readUTF();
//                System.out.println(in);
                presenter.printMessage(in);
                i++;
            }
        } catch (IOException e) {
            presenter.printMessage("Не удалось отправить сообщение");
        }
    }

    @Override
    public String getFormattedMessage(String message, String nickName) {
        return nickName + ": " + message;
    }
}
