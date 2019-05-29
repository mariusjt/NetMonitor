import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class GUI extends JFrame {
    private JLabel item1;
    private JLabel pingviewer;
    private JLabel speedtest;
    int ping;
    public GUI() {
        super("NETWORK TESTER");
        setLayout(new FlowLayout());
        /*Client client = new Client("127.0.0.1", 3333);
        try {
            client.speedTest(1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        long speed = client.getSpeed(); */
        PingIP pinger = new PingIP();
        item1 = new JLabel("Hover over this text to show ping");
        item1.setToolTipText("Your ping is: " + pinger.ping());
        add(item1);
        pingviewer = new JLabel("PING: " + ping + "ms" );
        pingviewer.setVerticalAlignment(0);
        //add(pingviewer);
        //speedtest = new JLabel("Speed: " + speed + "KB/s");
       // add(speedtest);
        final JTextField tf=new JTextField();
        tf.setBounds(150,50,150,30);
        JButton b=new JButton("Click Here");
        b.setBounds(50,100,95,30);
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ping();
            }
        });
        add(b);
        add(tf);

    }
    private void ping(){
        PingIP pinger = new PingIP();
        ping = pinger.ping();
        add(pingviewer);
    }
}
