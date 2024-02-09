package client;

import server.Server;

public interface Client {

    void printMessage(String message);

    void setServer(Server server);

}
