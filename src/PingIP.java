import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PingIP {
    private int ping;
    private int average;

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
            average = 0;
            int counts = 0;
            int total = 0;
            if (os.contains("win")){
                while ((s = inputStream.readLine()) != null && System.currentTimeMillis() < end && !s.contains("statistics")) {
                    if (s.contains("ms")) {
                        System.out.println(s);
                        counts++;
                        total = total + Integer.parseInt(s.substring((s.length() - 5), s.length() - 3));
                        average = total/counts;
                        System.out.println(average);
                        pinglist.add(ping);
                    }
                }
            }
            else if (os.contains("osx")) {
                while ((s = inputStream.readLine()) != null && System.currentTimeMillis() < end) {
                    //System.out.println(s);
                    if (s.contains("ms")) {
                        System.out.println(s);
                        counts++;
                        total = total + Integer.parseInt(s.substring((s.length() - 9), s.length() - 7));
                        average = total/counts;
                        System.out.println(average);
                        pinglist.add(ping);
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
/*
    public static void main(String[] args) {

        String ip = "google.com";
        runSystemCommand("ping " + ip);


    }
    */
    public int ping(){
        runSystemCommand("ping " + "google.com");
        return average;
    }

}