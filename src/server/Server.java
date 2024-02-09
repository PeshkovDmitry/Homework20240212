package server;

import client.Client;

public interface Server {

    void addSubscriber(Client client);

    void publish(String message);

    String getHistory();

}
