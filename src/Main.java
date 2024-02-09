import client.ChatClient;
import client.Client;
import client.view.ChatClientView;
import server.ChatServer;
import server.Server;

public class Main {

    public static void main(String[] args) {

        Server server = new ChatServer();
        Client client1 = new ChatClient(server);
//        Client client2 = new ChatClient(server);



    }

}