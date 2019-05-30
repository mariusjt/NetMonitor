import javax.swing.*;
import java.io.IOException;

/*Starts GUI. GUI should start other objects as needed */
public class Main extends GUI{
    public static void main(String[] args) throws IOException, InterruptedException {
        GUI gui = new GUI();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(480, 360);
        gui.setVisible(true);
    }
}
