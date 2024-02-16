package server.presenter;

import server.model.Model;
import server.view.View;

public class ChatServerPresenter implements Presenter{

    private Model model;

    private View view;

    public ChatServerPresenter(Model model, View view) {
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
    public void startServer() {
        model.startServer();
    }

    @Override
    public void stopServer() {
        model.stopServer();
    }

    @Override
    public void printMessage(String message) {
        view.printMessage(message);
    }

}
