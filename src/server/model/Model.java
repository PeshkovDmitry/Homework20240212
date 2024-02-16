package server.model;

import server.presenter.Presenter;

public interface Model {

    boolean isActive();

    void startServer();

    void stopServer();

    void setPresenter(Presenter presenter);


}
