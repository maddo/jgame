import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class PlayerShip {
    
    private int posX;
    private int posY;

    private int offsetX;
    private int offsetY;

    private BufferedImage ship;

    public PlayerShip(int x, int y, boolean hero) {
        posX = x;
        posY = y;

        offsetX = 2;
        offsetY = 3;

        try {
            if (hero) {
                ship = ImageIO.read(getClass().getResourceAsStream("/images/HeroShip.png"));
            } else {
                ship = ImageIO.read(getClass().getResourceAsStream("/images/EvilShip.png"));
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "There was an error loading the image");
        }
    }

    public void update() {
        if (posX <= 0 || (posX + ship.getWidth()) >= GameFrame.GAME_WIDTH) {
            offsetX = -1 * offsetX;
        }
        if (posY <= 0 || (posY + ship.getHeight()) >= GameFrame.GAME_HEIGHT) {
            offsetY = -1 * offsetY;
        }

        posX += offsetX;
        posY += offsetY;
    }

    public void reverseShip() {
        offsetX = -1 * offsetX;
    }

    public void render(Graphics g) {
        g.drawImage(ship, posX, posY, null);
    }
}