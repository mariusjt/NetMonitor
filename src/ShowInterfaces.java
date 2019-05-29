import java.net.*;
import java.util.*;

// Finds the IPv4 or IPv6. This favours IPv6, but if you don't have IPv6 it returns the IPv4, which often is 127.0.0.1.

public class ShowInterfaces {

    public static void main(String[] args) throws Exception
    {
        System.out.println("Host addr: " + InetAddress.getLocalHost().getHostAddress());  // often returns "127.0.0.1"
        Enumeration<NetworkInterface> n = NetworkInterface.getNetworkInterfaces();
        for (; n.hasMoreElements();)
        {
            NetworkInterface e = n.nextElement();
            System.out.println("Interface: " + e.getName());
            Enumeration<InetAddress> a = e.getInetAddresses();
            for (; a.hasMoreElements();)
            {
                InetAddress addr = a.nextElement();
                System.out.println("  " + addr.getHostAddress());
            }
        }
    }
}

