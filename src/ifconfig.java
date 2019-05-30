import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
/*
public class ifconfig {

    public static void main(String args[]) {
final List<String> commands = new ArrayList<>();
        commands.add("ipconfig");
        commands.add("/all");
        commands.add("|");
        commands.add("find");
        commands.add("\"IPv\"");
        ProcessBuilder pb = new ProcessBuilder(commands);

        try {
            Process p;
            p = Runtime.getRuntime().exec(String.valueOf(commands));
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line=reader.readLine();

            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }

        }

        catch(IOException e1) {}
        catch(InterruptedException e2) {}

        System.out.println("finished.");
    }
}
*/

//ipconfig /all | find "IPv"
//ipconfig /all | find "DHCP Server"