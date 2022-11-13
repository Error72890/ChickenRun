package Controller;

import View.Game_View;
import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Game_Controller implements ActionListener{
    private Game_View game_View;
    
    private final Font smallFont = new Font("Arial", Font.BOLD, 14);
    private boolean runningGame = false;
    private boolean collision = false;

    private final int BLOCK_SIZE = 16;
    private final int N_BLOCKS = 19;
    private final int SCREEN_SIZE = N_BLOCKS * BLOCK_SIZE;

    public Game_Controller(Game_View game_View){
        this.game_View = game_View;
        this.game_View.addKeyListener(new KeyboardAdapter());
        this.game_View.setFocusable(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        game_View.repaint();
    }
   
    public class KeyboardAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            switch (key) {
                case KeyEvent.VK_LEFT:
                    System.out.println("left");
                    break;
                case KeyEvent.VK_RIGHT:
                    System.out.println("r");
                    break;
                case KeyEvent.VK_UP:
                    System.out.println("u");
                    break;
                case KeyEvent.VK_DOWN:
                    System.out.println("d");
                    break;
                case KeyEvent.VK_ESCAPE:
                    System.out.println("e");
                    break;
                case KeyEvent.VK_SPACE:
                    System.out.println("s");
                    break;
                default:
                    break;
            }
        }
    }
}
