package client.model;

public class ChatClientModel implements Model{

    @Override
    public String getFormattedMessage(String message, String nickName) {
        return nickName + ": " + message;
    }
}
