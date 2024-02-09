package client.presenter;

import client.model.Model;
import client.view.View;

public class ChatClientPresenter implements Presenter {

    private Model model;

    private View view;

    public ChatClientPresenter(View view, Model model) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void setHost(String host) {

    }

    @Override
    public void setPort(Integer port) {

    }

    @Override
    public void setNickname(String nickName) {

    }

    @Override
    public void setPassword(String password) {

    }

    @Override
    public void connect() {

    }

    @Override
    public void sendMessage(String message) {

    }
}
