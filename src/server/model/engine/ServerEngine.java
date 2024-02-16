package server.model.engine;

public interface ServerEngine extends Runnable {
    void stop();

    boolean isStoppingServer();

    boolean isClosed();

    @Override
    void run();
}
