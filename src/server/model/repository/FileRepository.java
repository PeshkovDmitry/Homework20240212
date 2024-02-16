package server.model.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class FileRepository implements Repository {

    private static final String FILENAME = "history.txt";

    private String content = "";

    public FileRepository() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                    stringBuilder.append("\n\r" + line);
                }
            }
            content = stringBuilder.toString();
        } catch (Exception e) {}
    }

    @Override
    public void addToHistory(String message) {
        if (content.isEmpty()) {
            content = message;
        } else {
            content = content + "\n\r" + message;
        }
        try (FileWriter fileWriter = new FileWriter(FILENAME, true)) {
            fileWriter.write("\n\r" + message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getContent() {
        return content;
    }
}
