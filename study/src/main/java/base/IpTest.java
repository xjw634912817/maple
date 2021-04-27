package base;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpTest {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address.getHostAddress());
    }
}
