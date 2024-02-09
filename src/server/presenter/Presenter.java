package server.presenter;

import client.Client;

public interface Presenter {

    void start();

    void stop();

    void publish(String message);

    void addSubscriber(Client client);

    String getHistory();


}
