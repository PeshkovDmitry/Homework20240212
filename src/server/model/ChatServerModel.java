package server.model;

import server.presenter.Presenter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class ChatServerModel implements Model {

    private static final String FILENAME = "history.txt";

    private Presenter presenter;

    private MultiThreadServer multiThreadServer;

    @Override
    public boolean isActive() {
        if (multiThreadServer!= null) return false;
        return !multiThreadServer.isClosed();
    }

    @Override
    public void startServer() {
        multiThreadServer = new MultiThreadServer(presenter);
        Thread thread = new Thread(multiThreadServer);
        thread.start();
    }

    @Override
    public void stopServer() {
        if (isActive()) {
            multiThreadServer.close();
            presenter.printMessage("Сервер остановлен!");
        }
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
