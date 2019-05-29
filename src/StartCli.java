import java.io.IOException;

public class StartCli {
    public static void main(String[] args) throws IOException {
        Client tx = new Client(4);
        System.out.println("Client started!");
    }
}
