import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel implements ActionListener {
    
    PlayerShip shipHero;
    PlayerShip shipEvil;

    public GamePanel() {
        shipHero = new PlayerShip(120, 20, 2, 3, true);
        shipEvil = new PlayerShip(300, 50, 1, 5, false);
        shipEvil.reverseShip();
        Timer time = new Timer(15, this);
        time.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        handleInput();
        if (shipEvil.collides(shipHero)) {
            
        } else {
            update();    
        }
        
        repaint();
    }

    public void update() {
        shipHero.update();
        shipEvil.update();
    }

    public void handleInput() {
        
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.black);
        g.fillRect(0,0, GameFrame.GAME_WIDTH, GameFrame.GAME_HEIGHT);

        shipHero.render(g);
        shipEvil.render(g);
    }
    
}