package server.model.engine;

import server.model.engine.MultiThreadServer;
import server.model.repository.Repository;
import server.presenter.Presenter;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MonoThreadClientHandler implements Runnable {

    private Socket client;

    private Presenter presenter;

    private Repository repository;

    private MultiThreadServer multiThreadServer;

    public MonoThreadClientHandler(Socket client, Presenter presenter, Repository repository, MultiThreadServer multiThreadServer) {
        this.client = client;
        this.presenter = presenter;
        this.repository = repository;
        this.multiThreadServer = multiThreadServer;
    }

    @Override
    public void run() {
        try (DataOutputStream out = new DataOutputStream(client.getOutputStream());
             DataInputStream in = new DataInputStream(client.getInputStream())) {
            while (!client.isClosed()) {
                String entry = in.readUTF();
                presenter.printMessage(entry);
                if (!entry.trim().isEmpty()) {
                    repository.addToHistory(entry);
                }
                String response = multiThreadServer.isStoppingServer()
                        ? "exit"
                        : repository.getContent();
                out.writeUTF(response);
                out.flush();
            }
            client.close();
        } catch (IOException e) {}
    }
}
