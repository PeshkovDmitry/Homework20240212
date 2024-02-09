package server.model;

import client.Client;

public interface Model {

    void addSubscriber(Client client);

    void publish(String message);

    String getHistory();

}
