package client.presenter;

public interface Presenter {

    void onButtonClicked();

    boolean connect(String host, String port, String nickName, String password);

    void printMessage(String message);


//    void run();
//
//    void connect();
//
    void sendMessage(String message);
//
//    void printMessage(String message);
//
//    void disconnect();


}
