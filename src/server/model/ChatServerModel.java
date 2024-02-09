package server.model;

import client.Client;

import java.io.*;

public class ChatServerModel implements Model {

    private static final String FILENAME = "history.txt";

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
