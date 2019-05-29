import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Starting server!");
        Server rx = new Server(3333);
    }
}
