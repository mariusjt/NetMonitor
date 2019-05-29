import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPstatus {

    public static void main(String[] args) {

        InetAddress ip;
        try {

            ip = InetAddress.getLocalHost();
            System.out.println("Your current IP address : " + ip.getHostAddress());

        } catch (UnknownHostException e) {

            e.printStackTrace();

        }

    }

}