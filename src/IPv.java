import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class IPv {
String ipv4;
    public String test() throws IOException, InterruptedException {

        String os = System.getProperty("os.name").toLowerCase();
        String cmd = "";
        if (os.contains("win")) {
            cmd = "ipconfig /all";
        }
        else if (os.contains("mac")) {
            cmd = "ifconfig";
        } else { System.out.println("OS not supported, sorry");}

        ProcessBuilder builder = new ProcessBuilder(cmd);
        builder.redirectErrorStream(true);
        Process process = builder.start();
        InputStream is = process.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        String s;

        if (os.contains("mac")) {
            while ((s = reader.readLine()) != null) {
                if (s.contains("broadcast")) {
                s = s.substring(0,20);
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < s.length(); i++){
                    char c = s.charAt(i);
                    if (Character.isDigit(c)|| Character.toString(c).contains(".")){
                        sb.append(c);
                    }
                }
                System.out.println("IPv4: " + sb.toString());
                ipv4 = sb.toString();
                }
            }
        } else if (os.contains("win")) {
            while ((s = reader.readLine()) != null) {
                if (s.contains("IPv")) {
                    System.out.println(s);
                }
            }
        }   return ipv4;
    }
}



