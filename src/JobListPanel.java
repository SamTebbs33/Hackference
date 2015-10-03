import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by admin on 03/10/2015.
 */
public class JobListPanel extends JPanel {
    List

    public JobListPanel(Dimension screenSize) {
        this.setSize(screenSize);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


    }
}
