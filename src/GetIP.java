import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.UnknownHostException;

public class GetIP {

    public static void main(String[] args) throws UnknownHostException {
        System.out.println(Inet4Address.getLocalHost());
        System.out.println(Inet6Address.getLocalHost());
    }
}
