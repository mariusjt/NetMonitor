import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PingIP {
    private int ping;

    private void  runSystemCommand(String command) {

        try {
            Process p = Runtime.getRuntime().exec(command);
            BufferedReader inputStream = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));

            String s = "";
            ArrayList<Integer> pinglist = new ArrayList<Integer>();
            // reading output stream of the command
            long start = System.currentTimeMillis();
            long end = start+5000;
            String os = System.getProperty("os.name").toLowerCase();

            if (os.contains("win")){
                while ((s = inputStream.readLine()) != null && System.currentTimeMillis() < end) {
                    if (s.contains("ms")) {
                        System.out.println(s);
                        ping = Integer.parseInt(s.substring((s.length() - 5), s.length() - 3));
                        System.out.println(ping);
                        pinglist.add(ping);
                    }
                }
            }
            else if (os.contains("osx")) {
                while ((s = inputStream.readLine()) != null && System.currentTimeMillis() < end) {
                    //System.out.println(s);
                    if (s.contains("ms")) {
                        System.out.println(s);
                        ping = Integer.parseInt(s.substring((s.length() - 9), s.length() - 7));
                        System.out.println(ping);
                        pinglist.add(ping);
                        //s.regionMatches().;
                    }
                }
            }
            for (Object o : pinglist) {
                System.out.println("ping = " + o);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        String ip = "google.com";
        runSystemCommand("ping " + ip);


    }

    public int ping(){
        runSystemCommand("ping " + "google.com");
        return ping;
    }

}
