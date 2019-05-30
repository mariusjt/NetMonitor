import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class IPv {
String ipv4;

    /**
     * @return IPv4
     * @throws IOException Could be lack of permissions
     */
    public String test() throws IOException {
        // Specifies which string to be used.
        String os = System.getProperty("os.name").toLowerCase();
        String cmd = "";
        if (os.contains("win")) {
            cmd = "ipconfig";
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
        // IPv4 retriever for mac.
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
        // IPv4 retriever for win.
        } else if (os.contains("win")) {
            while ((s = reader.readLine()) != null) {
                if (s.contains("IPv4")&!s.contains("Temporary")&!s.contains("Link-local")) {
                    System.out.println(s);
                    //s = s.substring(s.length());
                    StringBuilder sb = new StringBuilder();
                    for (int i = s.length()-1; i > 0; i--){
                        char c = s.charAt(i);
                        if(Character.toString(c).contains(":")){
                            break;
                        }
                        if (Character.isDigit(c)|| Character.toString(c).contains(".")){
                            sb.append(c);
                        }
                    }
                    System.out.println("IPv4: " + sb.toString());
                    ipv4 = sb.toString();
                }
            }
        }   return ipv4;
    }
}



