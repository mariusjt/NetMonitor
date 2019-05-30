import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.awt.event.*;

/*Main for Java class GUI. Displays PING */
public class Main extends GUI{
    public static void main(String[] args) throws IOException, InterruptedException {

  /*     System.out.println("Starting server!");
        Server rx = new Server(3333); */
   /*     class GUI extends JFrame {
            private JLabel item1;
            private JLabel pingviewer;
            private JLabel speedtest;

            private GUI() {
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
*/

        GUI gui = new GUI();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(480, 360);
        gui.setVisible(true);
/*
        final JTextField tf=new JTextField();
        tf.setBounds(50,50,150,30);
        JButton b=new JButton("Click Here");
        b.setBounds(50,100,95,30);
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                tf.setText("Welcome to Javapoint" + speed);
            }
        });
        gui.add(b);gui.add(tf);
        gui.setSize(400,400);
        gui.setLayout(null);
        gui.setVisible(true); */
    }
}
