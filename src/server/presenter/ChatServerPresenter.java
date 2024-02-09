package server.presenter;

import client.Client;
import server.model.Model;
import server.view.View;

public class ChatServerPresenter implements Presenter{

    private Model model;

    private View view;

    public ChatServerPresenter(Model model, View view) {

    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void publish(String message) {

    }

    @Override
    public void addSubscriber(Client client) {

    }

    @Override
    public String getHistory() {
        return null;
    }
}
