package server.model;

import server.presenter.Presenter;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MonoThreadClientHandler implements Runnable {

    private Socket clientDialog;

    private Presenter presenter;

    public MonoThreadClientHandler(Socket client, Presenter presenter) {
        this.clientDialog = client;
        this.presenter = presenter;
    }

    @Override
    public void run() {

        try {
            DataOutputStream out = new DataOutputStream(clientDialog.getOutputStream());
            DataInputStream in = new DataInputStream(clientDialog.getInputStream());
            while (!clientDialog.isClosed()) {
                String entry = in.readUTF();
                System.out.println(entry);
                presenter.printMessage("READ from clientDialog message - " + entry);
                out.writeUTF("Server reply - " + entry + " - OK");
                out.flush();
            }
            in.close();
            out.close();
            clientDialog.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
