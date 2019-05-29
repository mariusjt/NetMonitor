import javax.swing.*;
import java.awt.*;


public class GUI extends JFrame {
    private JLabel item1;
    private JLabel item2;
    public GUI()
    {
        super("NETWORK TESTER");
        setLayout(new FlowLayout());


        item1 = new JLabel("this is a sentence");
        item1.setToolTipText("Your ping is: ");
        add(item1);

    }

}