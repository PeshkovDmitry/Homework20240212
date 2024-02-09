package client.presenter;

import client.Client;
import client.model.Model;
import client.view.View;
import server.Server;

public class ChatClientPresenter implements Presenter {

    private Model model;

    private View view;

    private Server server;

    private Client client;

    private String host;

    private int port;

    private String nickName;

    private String password;

    private boolean isRunning = false;

    public ChatClientPresenter(View view, Model model, Server server, Client client) {
        this.model = model;
        this.view = view;
        this.server = server;
        this.client = client;
        this.view.setPresenter(this);
    }

    @Override
    public void setHost(String host) {
        this.host = host;
    }

    @Override
    public void setPort(String port) {
        this.port = Integer.parseInt(port);
    }

    @Override
    public void setNickname(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String getNickname() {
        return nickName;
    }

    @Override
    public void setPassword(char[] password) {
        this.password = password.toString();
    }

    @Override
    public void run() {
        view.showWindow();
    }

    @Override
    public void connect() {
        if (server.checkRunning() && server.checkClient(nickName, password)) {
            view.hideSettingsWindow();
            view.printMessage(server.getHistory());
            view.printMessage("Вы успешно подключились!");
            server.addSubscriber(client);
            isRunning = true;
        } else {
            view.printMessage("Не удалось подключиться к серверу");
        }
    }

    @Override
    public void sendMessage(String message) {
        if (server.checkClient(nickName, password)) {
            server.publish(model.getFormattedMessage(message, nickName));
        }
    }

    @Override
    public void printMessage(String message) {
        if (isRunning) {
            view.printMessage(message);
        }
    }

    @Override
    public void disconnect() {
        view.clear();
        view.showSettingsWindow();
        isRunning = false;
    }
}
