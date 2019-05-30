import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.UnknownHostException;

/* Simple yet efficient method for IP catching. */
public class GetIP {

    /* Possibly idea is to change this format. Third row is not struck
       You can remove line 11 and the code gives the same answer. */
    public static void main(String[] args) throws UnknownHostException {
        System.out.println(Inet4Address.getLocalHost());
        System.out.println(Inet6Address.getLocalHost());
    }
}
