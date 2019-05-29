import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Starting server!");
        Server rx = new Server(3333);
    }
}
