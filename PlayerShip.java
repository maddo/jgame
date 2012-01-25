import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Rectangle;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class PlayerShip {
    
    private int posX;
    private int posY;

    private int offsetX;
    private int offsetY;

    private Rectangle box;

    private BufferedImage ship;

    public PlayerShip(int x, int y, int xSpeed, int ySpeed, boolean hero) {
        posX = x;
        posY = y;

        offsetX = xSpeed;
        offsetY = ySpeed;

        box = new Rectangle(x, y, 64, 64);

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

        box.setLocation((int) box.getX() + offsetX, (int) box.getY() + offsetY);
    }

    public boolean collides(PlayerShip other) {
        if (box.intersects(other.box.getBounds()))
            return true;
        else
            return false;
    }

    // Returns the boundingBox
    public Rectangle getBounds() {
        return box;
    }

    public void reverseShip() {
        offsetX = -1 * offsetX;
    }

    public void render(Graphics g) {
        g.drawImage(ship, posX, posY, null);
    }
}