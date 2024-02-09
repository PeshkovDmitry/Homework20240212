package server.presenter;

import client.Client;

public interface Presenter {

    void showWindow();

    void start();

    void stop();

    boolean checkRunning();

    void publish(String message);

    void addSubscriber(Client client);

    String getHistory();


}
