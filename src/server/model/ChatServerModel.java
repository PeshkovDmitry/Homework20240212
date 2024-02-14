package server.model;

import server.presenter.Presenter;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatServerModel implements Model {

    private static final String FILENAME = "history.txt";

    private Presenter presenter;

    private ServerSocket server;

    @Override
    public boolean isActive() {
        return !server.isClosed();
    }

    @Override
    public void startServer() {
        MultiThreadServer multiThreadServer = new MultiThreadServer(presenter);
        new Thread(multiThreadServer).start();
        server = multiThreadServer.getServerSocket();


//                    socket = serverSocket.accept();
//                    presenter.printMessage("Кто-то подключился!");
//                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//                    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//                    String word = in.readLine();
//                    System.out.println("Что-то пришло");
//                    presenter.printMessage(word);
//                    out.write("You say " + word);
//                    out.flush();
//                    in.close();
//                    out.close();
//                    serverSocket.close();
    }

    @Override
    public void stopServer() {
        try {
            server.close();
            presenter.printMessage("Сервер остановлен!");
        } catch (IOException e) {}
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }



    @Override
    public String getHistory() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                    stringBuilder.append("\n\r" + line);
                }
            }
            return stringBuilder.toString();
        } catch (Exception e) {
            return "";
        }
    }

    @Override
    public void addToHistory(String message) {
        try (FileWriter fileWriter = new FileWriter(FILENAME, true)) {
            fileWriter.write("\n\r" + message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
