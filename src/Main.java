import javax.swing.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Starting server!");
        Server rx = new Server(3333);

        GUI bucky = new GUI();
        bucky.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bucky.setSize(275, 180);
        bucky.setVisible(true);


    }
}
