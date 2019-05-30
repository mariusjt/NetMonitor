import java.io.*;
import java.util.Arrays;
/*
public class cmdIP {
    public static void main(String [] args) throws IOException {

        String os = System.getProperty("os.name").toLowerCase();
        String[] command = {"ipconfig", "/all", "|", "find", "\"IPv\""};
        ProcessBuilder probuilder = new ProcessBuilder(command);
        //final ProcessBuilder directory = probuilder.directory(new File("C:\\Users\\LUDAPCMASTERRACE"));

        Process process = probuilder.start();

        //Read out dir output
        InputStream is = process.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String line;
        System.out.printf("Output of running %s is:\n",
                Arrays.toString(command));
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        if (os.contains("win")) {
            while ((s = inputStream.readLine()) != null && System.currentTimeMillis() < end) {
                if (s.contains("ping")) {
                    System.out.println(s);
                }
        //Wait to get exit value
        try {
            int exitValue = process.waitFor();
            System.out.println("\n\nExit Value is " + exitValue);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Finished.");
    }

}
*/
//ipconfig /all | find "IPv"
//ipconfig /all | find "DHCP Server"