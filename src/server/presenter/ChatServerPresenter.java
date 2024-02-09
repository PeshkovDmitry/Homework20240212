package server.presenter;

import client.Client;
import server.model.Model;
import server.view.View;

import java.util.ArrayList;
import java.util.List;

public class ChatServerPresenter implements Presenter{

    private Model model;

    private View view;

    private boolean run;

    List<Client> subscribers;

    public ChatServerPresenter(Model model, View view) {
        subscribers = new ArrayList<>();
        this.model = model;
        this.view = view;
        this.view.setPresenter(this);
        run = false;
    }

    @Override
    public void showWindow() {
        view.showWindow();
    }

    @Override
    public void start() {
        run = true;
        publish(getHistory());
        publish("Сервер запущен!");
    }

    @Override
    public void stop() {
        run = false;
    }

    @Override
    public boolean checkRunning() {
        return run;
    }

    @Override
    public void publish(String message) {
        if (message != null && !message.isEmpty()) {
            view.printMessage(message);
            for (Client c: subscribers) {
                c.printMessage(message);
            }
        }
    }

    @Override
    public void addSubscriber(Client client) {
        subscribers.add(client);
        publish(client.getName() + " подключился к беседе");
    }

    @Override
    public String getHistory() {
        return null;
    }
}
