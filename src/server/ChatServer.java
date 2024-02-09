package server;

import client.Client;
import server.model.ChatServerModel;
import server.model.Model;
import server.presenter.ChatServerPresenter;
import server.presenter.Presenter;
import server.view.ChatServerView;
import server.view.View;

public class ChatServer implements Server {

    private Model model;

    private View view;

    private Presenter presenter;

    public ChatServer() {
        model = new ChatServerModel();
        view = new ChatServerView();
        presenter = new ChatServerPresenter(model,view);
        presenter.showWindow();
    }

    @Override
    public boolean checkClient(String nickName, String password) {
        return true;
    }

    @Override
    public boolean checkRunning() {
        return presenter.checkRunning();
    }

    @Override
    public void addSubscriber(Client client) {
        presenter.addSubscriber(client);
    }

    @Override
    public void publish(String message) {
        presenter.publish(message);
    }

    @Override
    public String getHistory() {
        return presenter.getHistory();
    }
}
