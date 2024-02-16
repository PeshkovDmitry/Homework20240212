package client.model;

import client.presenter.Presenter;

public interface Model {

    boolean connect(String host, int port);

    void setPresenter(Presenter presenter);

    void sendMessage(String message);

}
