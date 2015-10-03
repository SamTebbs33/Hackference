import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Created by admin on 03/10/2015.
 */
public class SearchPanel extends JPanel {
    Image backgroundImage = null;
    JLabel jobLabel;
    JTextField jobField;
    JLabel locationLabel;
    JTextField locationField;

    Dimension textFieldSize = new Dimension(300, 45);



    public SearchPanel(Dimension dimension){
        this.setSize(dimension);

        jobField = new JTextField();
        locationField = new JTextField();

        jobLabel = new JLabel("Job role");
        locationLabel = new JLabel("Location");

        jobField.setSize(textFieldSize);
        locationField.setSize(textFieldSize);

        jobField.setLocation(this.getWidth()/2 - (int)textFieldSize.getWidth()/2, 400);
        locationField.setLocation(this.getWidth()/2 - (int)textFieldSize.getWidth(), 500);

        this.add(jobField);
        this.add(locationField);

        try {
            backgroundImage = ImageIO.read(new File("res/login_background.png"));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.drawImage(backgroundImage, 0, 0, this);

    }
}
