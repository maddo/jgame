import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PictureFrame extends JFrame {
    
    public PictureFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(30,30,400,400);

        try {
            add(new PicturePanel());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "There was an error finding the picture.");
        }

        setVisible(true);
    }

    class PicturePanel extends JPanel {
        BufferedImage img;

        public PicturePanel() throws IOException {
            img = ImageIO.read(getClass().getResourceAsStream("/images/HeroShip.png"));
        }

        public void paintCompenent(Graphics g) {
            g.drawImage(img, 5, 5, null);
        }
    }

    public static void main(String[] args) {
        new PictureFrame();
    }
}