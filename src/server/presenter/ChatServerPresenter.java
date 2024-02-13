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


//
//
//    public void stop() {
//        run = false;
//        for (Client c: subscribers) {
//            c.disconnect();
//        }
//        view.clear();
//    }
//
//
//    public boolean checkRunning() {
//        return run;
//    }
//
//
//    public void publish(String message) {
//        if (message != null && !message.isEmpty()) {
//            view.printMessage(message);
//            model.addToHistory(message);
//            for (Client c: subscribers) {
//                c.printMessage(message);
//            }
//        }
//    }
//
//
//    public void addSubscriber(Client client) {
//        subscribers.add(client);
//        publish(client.getName() + " подключился к беседе");
//    }
//
//
//    public String getHistory() {
//        return model.getHistory();
//    }
}
