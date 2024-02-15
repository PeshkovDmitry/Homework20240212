package server.model;

import server.presenter.Presenter;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MonoThreadClientHandler implements Runnable {

    private Socket client;

    private Presenter presenter;

    public MonoThreadClientHandler(Socket client, Presenter presenter) {
        this.client = client;
        this.presenter = presenter;
    }

    @Override
    public void run() {
        try {
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            DataInputStream in = new DataInputStream(client.getInputStream());
            while (!client.isClosed()) {
                String entry = in.readUTF();
                presenter.printMessage(entry);
                out.writeUTF("Server reply - " + entry + " - OK");
                out.flush();
            }
            in.close();
            out.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
