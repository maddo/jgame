import javax.swing.JFrame;
import java.awt.BorderLayout;

public class GameFrame extends JFrame {
    public static final int GAME_WIDTH = 640;
    public static final int GAME_HEIGHT = 480;
    
    public GameFrame() {
        setTitle("Game Structure Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(GAME_WIDTH, GAME_HEIGHT);
        setResizable(false);
        
        GamePanel panel = new GamePanel();
        add(panel, BorderLayout.CENTER);
        
        setVisible(true);
    }

    public static void main(String[] args) {
        new GameFrame();
    }
}