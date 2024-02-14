package server.model;

import server.presenter.Presenter;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadServer implements Runnable {

    private static final int PORT = 4004;

    private ExecutorService executeIt = Executors.newFixedThreadPool(2);

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

    @Override
    public void run() {
        try {
            server = new ServerSocket(PORT);
            presenter.printMessage("Сервер запущен!");
            while (!server.isClosed()) {
                Socket client = server.accept();
                executeIt.execute(new MonoThreadClientHandler(client, presenter));
            }
            executeIt.shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
