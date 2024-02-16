package server.model.engine;

import server.model.repository.Repository;
import server.presenter.Presenter;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadServer implements ServerEngine {

    private static final int PORT = 3345;

    private ServerSocket server;

    private Presenter presenter;

    private Repository repository;

    private boolean stoppingServer = false;

    public MultiThreadServer(Presenter presenter, Repository repository) {
        this.presenter = presenter;
        this.repository = repository;
    }

    @Override
    public void stop() {
        try {
            stoppingServer = true;
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isStoppingServer() {
        return stoppingServer;
    }

    @Override
    public boolean isClosed() {
        return server.isClosed();
    }

    @Override
    public void run() {
        try {
            ExecutorService executeIt = Executors.newFixedThreadPool(2);
            server = new ServerSocket(PORT);
            presenter.printMessage("Сервер запущен!");
            while (!server.isClosed()) {
                Socket client = server.accept();
                executeIt.execute(new MonoThreadClientHandler(client, presenter, repository, this));
            }
            executeIt.shutdown();
            server.close();
            presenter.printMessage("Сервер остановлен!");
        } catch (IOException e) {}
    }
}
