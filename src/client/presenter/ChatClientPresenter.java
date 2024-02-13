package client.presenter;

import client.model.Model;
import client.view.View;

public class ChatClientPresenter implements Presenter {

    private Model model;

    private View view;

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
        return model.connect(host, Integer.parseInt(port));
//        if (server.checkRunning() && server.checkClient(nickName, password)) {
//            view.hideSettingsWindow();
//            view.printMessage(server.getHistory());
//            view.printMessage("Вы успешно подключились!");
////            server.addSubscriber(client);
//            isRunning = true;
//        } else {
//            view.printMessage("Не удалось подключиться к серверу");
//        }
    }

    @Override
    public void printMessage(String message) {
        view.printMessage(message);
    }

    @Override
    public void sendMessage(String message) {
        model.sendMessage(message);
    }

//    @Override
//    public void printMessage(String message) {
//        if (isRunning) {
//            view.printMessage(message);
//        }
//    }
//
//    @Override
//    public void disconnect() {
//        view.clear();
//        view.showSettingsWindow();
//        isRunning = false;
//    }
}
