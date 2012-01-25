import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel implements ActionListener {
    
    PlayerShip pShip1;
    PlayerShip pShip2;

    public GamePanel() {
        pShip1 = new PlayerShip(120, 20, true);
        pShip2 = new PlayerShip(300, 50, false);
        pShip2.reverseShip();
        Timer time = new Timer(15, this);
        time.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        handleInput();
        update();
        repaint();
    }

    public void update() {
        pShip1.update();
        pShip2.update();
    }

    public void handleInput() {
        
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.black);
        g.fillRect(0,0, GameFrame.GAME_WIDTH, GameFrame.GAME_HEIGHT);

        pShip1.render(g);
        pShip2.render(g);
    }
    
}