import com.sun.xml.internal.bind.Util;

import javax.swing.*;
import java.awt.*;

/**
 * Created by admin on 03/10/2015.
 */
public class Main2 {

    public static void main(String[] args){
        JFrame frame = new JFrame();

        frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        frame.setExtendedState(1);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MainPanel mainPanel = new MainPanel(frame.getSize());
        frame.add(mainPanel);

        frame.requestFocus();

        System.out.println(frame.getSize());

        while(true){

        }
    }
}
