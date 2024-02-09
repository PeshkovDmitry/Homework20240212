package client.presenter;

public interface Presenter {

    void setHost(String host);

    void setPort(String port);

    void setNickname(String nickName);

    String getNickname();

    void setPassword(char[] password);

    void run();

    void connect();

    void sendMessage(String message);

    void printMessage(String message);


}
