package client.presenter;

public interface Presenter {

    void onButtonClicked();

    boolean connect(String host, String port, String nickName, String password);

    void printMessage(String message);

    void sendMessage(String message);

    String getNickname();

    void setConnected(boolean connected);

}
