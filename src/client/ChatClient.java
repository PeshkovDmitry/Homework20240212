package client;

import client.model.ChatClientModel;
import client.model.Model;
import client.presenter.ChatClientPresenter;
import client.presenter.Presenter;
import client.view.ChatClientView;
import client.view.View;
import server.Server;

public class ChatClient implements Client {

    private Server server;
    private View view;
    private Model model;
    private Presenter presenter;


    public ChatClient(Server server) {
        this.server = server;
        this.view = new ChatClientView();
        this.model = new ChatClientModel();
        this.presenter = new ChatClientPresenter(view, model, server, this);
        presenter.run();
    }

    @Override
    public void printMessage(String message) {

    }

    @Override
    public void setServer(Server server) {

    }
}
