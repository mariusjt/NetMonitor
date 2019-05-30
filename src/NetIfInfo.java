
import java.io.*;
import java.net.*;
import java.util.*;


public class NetIfInfo
{
    private static final String NL = System.getProperty("line.separator");
    private static final String NL_TAB = NL + "  ";
    private static final String IPV4 = "IPv4";
    private static final String IPV6 = "IPv6";
    private static final String DHCP = "DHCP";
    private static class InterfaceInfo
    {
        public String displayName;
        public String name;
        public List<IpAddressInfo> ipAddresses;

        public String toString()
        {
            StringBuilder sb = new StringBuilder(NL);
            sb.append("*** Interface [" + name + "] ***").append(NL);

            for (IpAddressInfo ipAddr: ipAddresses)
            {
                sb.append(ipAddr);
            }

            return sb.toString();
        }
    }

    private static class IpAddressInfo
    {
        public String ipAddress;
        public String ipVersion = "unknown";
        public String hostName;
        public String DHCP;

        public String toString()
        {
            StringBuilder sb = new StringBuilder();
            sb.append(NL).append("INET address ("+ ipVersion + "): " + ipAddress);
            sb.append(NL_TAB).append("host name           : " + hostName);
            sb.append(NL_TAB).append("DHCP                : " + DHCP);

            return sb.toString();
        }
    }

    private static InterfaceInfo getInterfaceInfo(NetworkInterface nif) throws IOException
    {
        // get interface information
        InterfaceInfo info = new InterfaceInfo();
        info.displayName = nif.getDisplayName();
        info.name = nif.getName();
        info.ipAddresses = new ArrayList<IpAddressInfo>();

        // get IP address information
        Enumeration<InetAddress> inetAddresses = nif.getInetAddresses();
        while (inetAddresses.hasMoreElements())
        {
            InetAddress inetAddr = inetAddresses.nextElement();

            IpAddressInfo ipInfo = new IpAddressInfo();
            if (inetAddr instanceof Inet4Address)
            {
                ipInfo.ipVersion = IPV4;
            }
            else if (inetAddr instanceof Inet6Address)
            {
                ipInfo.ipVersion = IPV6;
            }
            ipInfo.ipAddress = inetAddr.getHostAddress();
            ipInfo.hostName = inetAddr.getHostName();

            info.ipAddresses.add(ipInfo);
        }

        // get virtual interface information

        return info;
    }

    public static void main(String[] args) throws IOException
    {
        Enumeration<NetworkInterface> interfaces =
                NetworkInterface.getNetworkInterfaces();

        while (interfaces.hasMoreElements())
        {
            NetworkInterface nif = interfaces.nextElement();
            System.out.println(getInterfaceInfo(nif));
        }
    }
}