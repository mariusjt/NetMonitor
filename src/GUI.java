import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.io.File;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class GUI extends JFrame {
    Button p;
    int ping;
    PingIP pinger;
    TrayIcon trayIcon;
    long spamTimeout;

    public GUI() {
        super("NETWORK TESTER");
        pinger = new PingIP();
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
        SystemTray tray = SystemTray.getSystemTray();
        //Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
        Image image = Toolkit.getDefaultToolkit().getImage(System.getProperty("user.dir") + File.separator + "icon.png");

        trayIcon = new TrayIcon(image, "Tray Demo");
        trayIcon.setImageAutoSize(true);
        trayIcon.setToolTip("TESTING!!!!");
        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            e.printStackTrace();
        }
        ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
        ses.scheduleAtFixedRate(new Runnable() {
            /*Display a warning if ping is higher than preferred.*/
            @Override
            public void run() {
                ping();
                if (ping > 5){
                    if (System.currentTimeMillis() > spamTimeout) {
                        trayIcon.displayMessage("Ping warning", "Your ping is: " + ping, TrayIcon.MessageType.INFO);
                        spamTimeout = System.currentTimeMillis() + 10000;
                        pingbox.setText("Ping: " + ping);
                    }

                }
            }
        }, 0, 5, TimeUnit.SECONDS);

    }

    private void ping() {
        ping = pinger.ping();
    }
}
