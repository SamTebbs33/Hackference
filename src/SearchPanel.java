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

        FlowLayout layout = new FlowLayout();


        jobField = new JTextField();
        locationField = new JTextField();

        jobLabel = new JLabel("Job role");
        locationLabel = new JLabel("Location");

        jobField.setSize(textFieldSize);
        locationField.setSize(textFieldSize);

        layout.addLayoutComponent("jobLabel", jobLabel);
        layout.addLayoutComponent("jobField", jobField);
        layout.addLayoutComponent("locationLabel", locationLabel);
        layout.addLayoutComponent("locationField", locationField);

        this.add(jobLabel);
        this.add(jobField);
        this.add(locationLabel);
        this.add(locationField);


        this.setLayout(layout);





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
