import java.io.IOException;

/* A launcher for Java class Client. */
public class StartCli {
    public static void main(String[] args) throws IOException {
        Client tx = new Client("127.0.0.1", 3333);
        System.out.println("Starting client!");
        tx.speedTest(10);
        long speed1 = tx.getSpeed();
        tx.speedTest(2);
        long speed2 = tx.getSpeed();
        /*Return speed test*/
        System.out.println("test1: " + speed1 + "test2: " + speed2);
        tx.close();
    }
}
