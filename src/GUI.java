import javax.swing.*;
import java.awt.*;


public class GUI extends JFrame {
    private JLabel item1;

    public GUI() {
        super("NETWORK TESTER");
        setLayout(new FlowLayout());

        PingIP pinger = new PingIP();
        item1 = new JLabel("Hover to get ping");
        item1.setToolTipText("Your ping is: " + pinger.ping());
        add(item1);
    }
}