package client.presenter;

public interface Presenter {

    void setHost(String host);

    void setPort(Integer port);

    void setNickname(String nickName);

    void setPassword(String password);

    void connect();

    void sendMessage(String message);


}
