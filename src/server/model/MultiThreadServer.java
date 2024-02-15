package server.model;

import server.presenter.Presenter;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadServer implements Runnable {

    private static final int PORT = 3345;

    private ServerSocket server;

    private Presenter presenter;

    public MultiThreadServer(Presenter presenter) {
        this.presenter = presenter;
    }

    public ServerSocket getServerSocket() {
        return server;
    }

    public void close() {
        try {
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
                presenter.printMessage("Кто-то подключился!");
                executeIt.execute(new MonoThreadClientHandler(client, presenter));
            }
            executeIt.shutdown();
            server.close();
            presenter.printMessage("Сервер остановлен!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
