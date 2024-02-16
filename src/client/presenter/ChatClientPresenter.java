package client.presenter;

import client.model.Model;
import client.view.View;

public class ChatClientPresenter implements Presenter {

    private Model model;

    private View view;

    private String nickName;

    public ChatClientPresenter(View view, Model model) {
        this.model = model;
        this.model.setPresenter(this);
        this.view = view;
        this.view.setPresenter(this);
    }

    @Override
    public void onButtonClicked() {
        view.showWindow();
    }

    @Override
    public boolean connect(String host, String port, String nickName, String password) {
        this.nickName = nickName;
        return model.connect(host, Integer.parseInt(port));
    }

    @Override
    public void printMessage(String message) {
        view.printMessage(message);
    }

    @Override
    public void sendMessage(String message) {
        model.sendMessage(message);
    }

    @Override
    public String getNickname() {
        return nickName;
    }

    @Override
    public void setConnected(boolean connected) {
        view.setConnected(connected);
    }

}
