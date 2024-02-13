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
        try {
//            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            out.write(message);
            out.flush();
        } catch (IOException e) {
            presenter.printMessage("Не удалось отправить сообщение");
        }
    }

    @Override
    public String getFormattedMessage(String message, String nickName) {
        return nickName + ": " + message;
    }
}
