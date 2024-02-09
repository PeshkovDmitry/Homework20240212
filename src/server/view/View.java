package server.view;

import server.presenter.Presenter;

public interface View {

    void showWindow();

    void setPresenter(Presenter presenter);

    void clear();

    void printMessage(String message);

}
