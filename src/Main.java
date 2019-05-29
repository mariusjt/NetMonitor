import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Instantiating objects!");
        Server rx = new Server(3333);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        if (br.readLine().equals("hei")) {
            //rx.stop();
            System.out.println("asdassdsa");
        } else {System.out.println("nope");}
            //rx.stop();



        //Client tx = new Client(1);
        //rx.stop();
        //Server rx = new Server();
        //Transmitter tx = new Transmitter("127.0.0.1", 5555);
        //Receiver rx = new Receiver("127.0.0.1", 5555);
        /*System.out.println("Successfully instantiated objects!");
        FileGen fg = new FileGen();
        fg.getFile(1);
        System.out.println("dir: " + fg.curDir);

        //tx.sendText(); */
    }
}
