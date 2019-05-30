import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI extends JFrame {
    Button p;
    int ping;

    public GUI() {
        super("NETWORK TESTER");
        setLayout(new FlowLayout());
        TextField pingbox = new TextField(20);
        pingbox.setText("not checked");
        add(pingbox);
        p = new Button("Click Here");
        p.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ping();
                pingbox.setText("Ping: " + ping + "ms");
            }
        });
        add(p);
    }

    private void ping(){
        PingIP pinger = new PingIP();
        ping = pinger.ping();
    }
}
