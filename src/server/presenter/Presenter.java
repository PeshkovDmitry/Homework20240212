package server.presenter;

public interface Presenter {

    void onButtonClicked();

    void startServer();

    void stopServer();

    void printMessage(String message);

}
