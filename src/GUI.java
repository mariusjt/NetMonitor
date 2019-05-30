import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class GUI extends JFrame {
    private JLabel item1;
    private JLabel pingviewer;
    private JLabel speedtest;

    public GUI() {
        super("NETWORK TESTER");
        setLayout(new FlowLayout());
        Client client = new Client("127.0.0.1", 3333);
        try {
            client.speedTest(1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        long speed = client.getSpeed();
        PingIP pinger = new PingIP();
        item1 = new JLabel("Hover over this text to show ping");
        item1.setToolTipText("Your ping is: " + pinger.ping());
        add(item1);
        pingviewer = new JLabel("PING: " + pinger.ping() + "ms" );
        add(pingviewer);
        speedtest = new JLabel("Speed: " + speed + "KB/s");
        add(speedtest);
    }
}
