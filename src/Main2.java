import javax.swing.*;
import java.awt.*;

/**
 * Created by admin on 03/10/2015.
 */
public class Main2 {

    public static void main(String[] args){
        JFrame frame = new JFrame();

        frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);

        SearchPanel loginPanel = new SearchPanel(frame.getSize());
        //MainPanel mainPanel = new MainPanel(frame.getSize());
        frame.add(loginPanel);
        frame.repaint();

        //frame.add(mainPanel);

        System.out.println(frame.getSize());

    }
}
