import javax.swing.*;
import java.awt.*;


public class GUI extends JFrame {
    private JLabel item1;
    private JLabel pingviewer;

    public GUI() {
        super("NETWORK TESTER");
        setLayout(new FlowLayout());

        PingIP pinger = new PingIP();
        item1 = new JLabel("Hover over this text to show ping");
        item1.setToolTipText("Your ping is: " + pinger.ping());
        add(item1);
        pingviewer = new JLabel("PING: " + pinger.ping() + "ms" );
        add(pingviewer);
    }
}