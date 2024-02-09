package client;

import client.model.ChatClientModel;
import client.model.Model;
import client.view.ChatClientView;
import client.view.View;
import server.Server;

public class ChatClient implements Client {

    private Server server;

    public ChatClient(Server server) {
        this.server = server;
        View view = new ChatClientView();
        Model model = new ChatClientModel();
        view.showWindow();
    }

    @Override
    public void printMessage(String message) {

    }

    @Override
    public void setServer(Server server) {

    }
}
