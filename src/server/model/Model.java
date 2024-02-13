package server.model;

import client.Client;
import server.presenter.Presenter;

public interface Model {

    boolean isActive();

    void startServer();

    void stopServer();

    void setPresenter(Presenter presenter);

    String getHistory();

    void addToHistory(String message);

}
