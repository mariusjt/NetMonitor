import java.io.IOException;

public class StartCli {
    public static void main(String[] args) throws IOException {
        Client tx = new Client(1, "127.0.0.1", 3333);
        System.out.println("Client started!");
    }
}
