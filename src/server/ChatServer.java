package server;

import server.model.ChatServerModel;
import server.model.Model;
import server.presenter.ChatServerPresenter;
import server.presenter.Presenter;
import server.view.ChatServerView;
import server.view.View;

public class ChatServer {

    private Model model;

    private View view;

    private Presenter presenter;

    public ChatServer() {
        model = new ChatServerModel();
        view = new ChatServerView();
        presenter = new ChatServerPresenter(model,view);
        presenter.onButtonClicked();
    }

}
