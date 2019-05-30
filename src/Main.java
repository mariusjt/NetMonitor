import javax.swing.*;
import java.io.IOException;


/**
 * Opens GUI
 */
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        /*System.out.println("Starting server!");
        Server rx = new Server(3333);*/

        GUI gui = new GUI();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(480, 360);
        gui.setVisible(true);
    }
}
