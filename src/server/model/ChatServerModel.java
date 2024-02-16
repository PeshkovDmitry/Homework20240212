package server.model;

import server.model.engine.ServerEngine;
import server.model.engine.MultiThreadServer;
import server.model.repository.FileRepository;
import server.model.repository.Repository;
import server.presenter.Presenter;

public class ChatServerModel implements Model {

    private Repository repository = new FileRepository();

    private Presenter presenter;

    private ServerEngine serverEngine;

    @Override
    public boolean isActive() {
        if (serverEngine != null) return false;
        return !serverEngine.isClosed();
    }

    @Override
    public void startServer() {
        serverEngine = new MultiThreadServer(presenter, repository);
        Thread thread = new Thread(serverEngine);
        thread.start();
    }

    @Override
    public void stopServer() {
        serverEngine.stop();
        presenter.printMessage("Сервер остановлен!");
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

}
