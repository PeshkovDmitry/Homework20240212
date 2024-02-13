import client.ChatClient;
import server.ChatServer;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        new ChatServer();
        new ChatClient();
//        new ChatClient();

    }

}