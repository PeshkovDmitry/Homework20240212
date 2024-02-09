package server.model;

import client.Client;

public interface Model {

    String getHistory();

    void addToHistory(String message);

}
