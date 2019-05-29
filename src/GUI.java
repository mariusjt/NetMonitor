import javax.swing.*;
import java.awt.*;


public class GUI extends JFrame {
    private JLabel item1;

    public GUI()
    {
        super("NETWORK TESTER");
        setLayout(new FlowLayout());


        item1 = new JLabel("this is a sentence");
        item1.setToolTipText("Your ping is: ");
        add(item1);

        GUI bucky = new GUI();
        bucky.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bucky.setSize(275, 180);
        bucky.setVisible(true);

    }

}