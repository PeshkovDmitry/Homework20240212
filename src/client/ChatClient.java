package client;

import client.model.ChatClientModel;
import client.model.Model;
import client.presenter.ChatClientPresenter;
import client.presenter.Presenter;
import client.view.ChatClientView;
import client.view.View;

public class ChatClient {

    private View view;
    private Model model;
    private Presenter presenter;


    public ChatClient() {
        this.view = new ChatClientView();
        this.model = new ChatClientModel();
        this.presenter = new ChatClientPresenter(view, model);
        presenter.onButtonClicked();
    }



}
