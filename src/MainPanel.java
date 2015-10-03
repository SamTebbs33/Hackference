import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.URL;

/**
 * Created by admin on 03/10/2015.
 */
public class MainPanel extends JPanel {
    private String mapsApiKey = "";

    public MainPanel(Dimension screenSize){
        this.setSize(screenSize);

        try {
            BufferedReader br = new BufferedReader(new FileReader("apikeys.txt"));
            String read = br.readLine();
            mapsApiKey = read.substring(read.indexOf(":") + 1);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.drawImage(getMapImage("Madrid"), 0, 0, this);
    }

    public Image getMapImage(String location){
        Image mapImage;

        System.out.println(this.getWidth() + ", " + this.getHeight());

        try {

            String imageUrl = "http://maps.googleapis.com/maps/api/staticmap?center=" + location + "&size=" + this.getWidth() + "x" + this.getHeight() + "&style=element:labels|visibility:on&style=element:geometry.stroke|visibility:off&style=feature:road&key=" + mapsApiKey;
            String destinationFile = "tempmap.jpg";
            URL url = new URL(imageUrl);
            InputStream is = url.openStream();
            OutputStream os = new FileOutputStream(destinationFile);

            byte[] b = new byte[2048];
            int length;

            while ((length = is.read(b)) != -1) {
                os.write(b, 0, length);
            }
            is.close();
            os.close();
            mapImage = ImageIO.read(new File("tempmap.jpg"));

            return mapImage;
        } catch (IOException e) {
            System.out.println(e.toString());
        }

        return null;
    }

}

