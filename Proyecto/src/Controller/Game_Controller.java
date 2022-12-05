package Controller;

import Model.GameManager;
import View.Game_View;
import View.ScoreTable_View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Game_Controller implements ActionListener{
    private Game_View game_View;
    private final GameManager gameManager;
    private final GamePanel gamePanel;
    
    public Game_Controller(Game_View game_View){
        this.gameManager = new GameManager(this);
        this.game_View = game_View;
        this.gamePanel = new GamePanel(gameManager, game_View);
        this.game_View.getContentPane().add(this.gamePanel);
        this.game_View.addKeyListener(new KeyboardAdapter());
        this.game_View.setFocusable(true);
        this.game_View.getItem1().addActionListener(this);
        this.game_View.getItem2().addActionListener(this);
        gameManager.newGame();
        gameManager.initNewLevel(); 
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        game_View.repaint();
        if(game_View.getItem1() == event.getSource()){
            gamePanel.setRunningGame(false);
            gamePanel.setPaused(false);
            gameManager.newGame();
            gameManager.initNewLevel();
        }
        if(game_View.getItem2() == event.getSource()){
            gamePanel.setRunningGame(false);
            gamePanel.setPaused(true);
            ScoreTable_View scoreTable_View = new ScoreTable_View();
            ScoreTable_Controller scoreTable_Controller = new ScoreTable_Controller(scoreTable_View);
            scoreTable_View.setLocationRelativeTo(null);
            scoreTable_View.setVisible(true);
        }
    }
   
    public class KeyboardAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if (gamePanel.isRunningGame()) {
                if (key == KeyEvent.VK_LEFT) {
                    gameManager.setCtrlDirX(-1);
                    gameManager.setCtrlDirY(0);
                } else if (key == KeyEvent.VK_RIGHT) {
                    gameManager.setCtrlDirX(1);
                    gameManager.setCtrlDirY(0);
                } else if (key == KeyEvent.VK_UP) {
                    gameManager.setCtrlDirX(0);
                    gameManager.setCtrlDirY(-1);
                } else if (key == KeyEvent.VK_DOWN) {
                    gameManager.setCtrlDirX(0);
                    gameManager.setCtrlDirY(1);
                } else if (key == KeyEvent.VK_ESCAPE && gameManager.getTimer().isRunning()) {
                    gamePanel.setRunningGame(false);
                    gamePanel.setPaused(true);
                    gameManager.getTimer().stop();
                }
            } else {
                if (key == KeyEvent.VK_SPACE) {
                    if(gamePanel.isPaused()){
                        gamePanel.setRunningGame(true);
                        gamePanel.setPaused(false);
                        gameManager.getTimer().start();
                    }else{
                        if(gamePanel.isEnded()){
                            gamePanel.setEnded(false);
                            gameManager.newGame();
                            gameManager.initNewLevel();
                            
                        }else{
                            gamePanel.setRunningGame(true);
                        }
                    }
                }
            }
        }
    }
}
