import java.net.InetAddress;

public class tryIP {
    public static void main(String[] args) {
        try {
            System.out.println("IP Address : " + InetAddress.getLocalHost().getHostAddress());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
