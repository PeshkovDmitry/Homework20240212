package server.model.repository;

public interface Repository {

    void addToHistory(String message);

    String getContent();

}
