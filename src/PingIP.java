import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PingIP {
    private int average;
    //  Checks speed of the network currently connected within the DB desired Database.
    private void  runSystemCommand(String command) {

        try {
            Process p = Runtime.getRuntime().exec(command);
            BufferedReader inputStream = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));

            String s = "";
            // reading output stream of the command
            long start = System.currentTimeMillis();
            long end = start+5000;
            String os = System.getProperty("os.name").toLowerCase();
            average = 0;
            int counts = 0;
            int total = 0;
            // Checks if the user is operating on Windows Operating system.
            if (os.contains("win")){
                while ((s = inputStream.readLine()) != null && System.currentTimeMillis() < end && !s.contains("statistics")) {
                    if (s.contains("ms")) {
                        System.out.println(s);
                        counts++;
                        String noString = s.substring(s.length() -5, s.length()-3);
                        total = getTotal(counts, total, noString);
                    }
                }
            }
            // Checks if the user is operating on Mac OS X Operating system.
            else if (os.contains("os x")) {
                while ((s = inputStream.readLine()) != null && System.currentTimeMillis() < end) {
                    if (s.contains("ms")) {
                        System.out.println(s);
                        counts++;
                        String noString = s.substring(s.length() -9, s.length()-7);
                        total = getTotal(counts, total, noString);

                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Method that calculates PING values.
    private int getTotal(int counts, int total, String noString) {
        if (noString.contains("=") || noString.contains(" ")){
            noString = noString.substring(1);
        }
        total = total + Integer.parseInt(noString);
        average = total / counts;
        System.out.println(average);
        return total;
    }

    /**
     * @return average ping in ms
     * Defaults to google.com
     */
    public int ping(){
        runSystemCommand("ping " + "google.com");
        return average;
    }

    /**
     * @param ip IP to ping
     * @return average IP in ms
     */
    public int ping(String ip){
        runSystemCommand("ping " + ip);
        return average;
    }

}