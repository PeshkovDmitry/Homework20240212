package server;

import client.Client;
import server.model.Model;

public interface Server {

    boolean checkClient(String nickName, String password);

    void addSubscriber(Client client);

    void publish(String message);

    String getHistory();

}
