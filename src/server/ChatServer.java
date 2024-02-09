package server;

import client.Client;
import server.model.Model;
import server.presenter.Presenter;
import server.view.ChatServerView;
import server.view.View;

public class ChatServer implements Server {

    private Model model;

    private View view;

    private Presenter presenter;

    public ChatServer() {
        view = new ChatServerView();
        view.showWindow();
    }

    @Override
    public boolean checkClient(String nickName, String password) {
        return true;
    }

    @Override
    public void addSubscriber(Client client) {
        System.out.println(client);
    }

    @Override
    public void publish(String message) {
        presenter.publish(message);
    }

    @Override
    public String getHistory() {
        return "История...";
    }
}
