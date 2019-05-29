import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PingIP {

    public static void runSystemCommand(String command) {

        try {
            Process p = Runtime.getRuntime().exec(command);
            BufferedReader inputStream = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));

            String s = "";
            int ping;
            ArrayList pinglist = new ArrayList<Integer>();
            // reading output stream of the command
            long start = System.currentTimeMillis();
            long end = start+5000;
            while ((s = inputStream.readLine()) != null && System.currentTimeMillis() < end) {
                //System.out.println(s);
                if (s.contains("ms")){
                    System.out.println(s);
                    ping = Integer.parseInt(s.substring((s.length() -9), s.length() -7));
                    System.out.println(ping);
                    pinglist.add(ping);
                    //s.regionMatches().;
                }
            }
            for (int i = 0; i < pinglist.size(); i++){
                System.out.println("ping = " + pinglist.get(i));
            }
            /*
            while(inputStream.readLine().contains("[a-z]|[0-9]|[A-Z]")){
                System.out.println(s);
            }*/

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        String ip = "google.com";
        runSystemCommand("ping " + ip);


    }
}