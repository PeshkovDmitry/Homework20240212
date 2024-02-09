package client.view;

import client.presenter.Presenter;

public interface View {

    void showWindow();

    void printMessage(String message);

    void clear();

    void setPresenter(Presenter presenter);

    void showSettingsWindow();

    void hideSettingsWindow();

}
