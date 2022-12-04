package Controller;

import Model.GameManager;
import Util.SpriteBank;
import View.Game_View;
import View.ScoreTable_View;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class Game_Controller implements ActionListener{
    private Game_View game_View;
    private final GameManager gameManager;
    private final SpriteBank spriteBank;
    private boolean runningGame = false;
    private boolean paused = false;
    
    //Screen config
    private final Font smallFont = new Font("Arial", Font.BOLD, 14);
    private final int mapLength;
    private final int screenSize;
    private static final int INFO_SIZE = 40;

    
    public Game_Controller(Game_View game_View){
        spriteBank = new SpriteBank();
        gameManager = new GameManager(this);
        mapLength = gameManager.getMapLength();
        screenSize = gameManager.getBlockSize() * mapLength;
        this.game_View = game_View;
        this.game_View.getContentPane().add(new GamePanel());
        this.game_View.addKeyListener(new KeyboardAdapter());
        this.game_View.setFocusable(true);
        this.game_View.getItem1().addActionListener(this);
        this.game_View.getItem2().addActionListener(this);
        gameManager.newGame();
        gameManager.initNewLevel(); 
    }
    
    private void playGame(Graphics2D graphics) {
        gameManager.update();
        if (gameManager.getLives() == 0) {
            runningGame = false;
        }
        if (!gameManager.isCatched()) {
            drawChicken(graphics);
            drawFoxes(graphics);      
        }
    }
 
    
    class GamePanel extends JComponent{
        private static final long serialVersionUID = 1L;
        public GamePanel()
        {
            super();
            this.setLocation(0,0);
            this.setSize(screenSize + INFO_SIZE, screenSize + INFO_SIZE);
        }

        @Override
        public void paintComponent(Graphics g) {
            Graphics2D graphics = (Graphics2D) g;
            graphics.setColor(Color.black);
            graphics.fillRect(0, 0, screenSize, screenSize);

            drawMaze(graphics);
            drawScore(graphics);

            if (runningGame) {
                playGame(graphics);
            } else {
                if(paused){      
                    drawChicken(graphics);   
                    drawFoxes(graphics);             
                    showPauseScreen(graphics);
                }else{
                    showIntroScreen(graphics);
                }
            }
            Toolkit.getDefaultToolkit().sync();
            graphics.dispose();
        }
    }
    
    private void showIntroScreen(Graphics2D graphics) {
    	String start = "Press SPACE to start";
        graphics.setColor(Color.white);
        graphics.drawString(start, (screenSize)/4, 150);
    }  
    private void showPauseScreen(Graphics2D graphics) {
    	String start = "Press SPACE to Continue";
        graphics.setColor(Color.white);
        graphics.drawString(start, (screenSize)/4, 150);
    }  
    private void drawScore(Graphics2D graphics) {
        graphics.setFont(smallFont);
        graphics.setColor(Color.black);
        String s = "Score: " + gameManager.getScore();
        graphics.drawString(s, screenSize / 2, screenSize + 13);
        for (int i = 0; i < gameManager.getLives(); i++) {
            graphics.drawImage(new ImageIcon("src/Sprites/Gallina_Derecha.gif").getImage(), i * 25 + 10, screenSize , game_View);
        }
    }  
    private void drawMaze(Graphics2D graphics) {
        short i;
        for(i = 0; i < mapLength*mapLength; i++){
            switch(gameManager.getScreenData()[i]){
                case 0:
                    graphics.drawImage(spriteBank.CLEARFLOOR, (i % mapLength) * 16,  (i / mapLength) * 16, game_View);
                    break;
                case 1:
                    graphics.drawImage(spriteBank.CORNER1, (i % mapLength) * 16, (i / mapLength) * 16, game_View);
                    break;
                case 2:
                    graphics.drawImage(spriteBank.SIDE1,(i % mapLength) * 16, (i / mapLength) * 16, game_View);
                    break;
                case 3:
                    graphics.drawImage(spriteBank.CORNER2,(i % mapLength) * 16, (i / mapLength) * 16, game_View);
                    break;
                case 4:
                    graphics.drawImage(spriteBank.SIDE2,(i % mapLength) * 16, (i / mapLength) * 16, game_View);
                    break;
                case 5:
                    graphics.drawImage(spriteBank.CORNER3,(i % mapLength) * 16, (i / mapLength) * 16, game_View);
                    break;
                case 6:
                    graphics.drawImage(spriteBank.SIDE3,(i % mapLength) * 16, (i / mapLength) * 16, game_View);
                    break;
                case 7:
                    graphics.drawImage(spriteBank.CORNER4,(i % mapLength) * 16, (i / mapLength) * 16, game_View);
                    break;
                case 8:
                    graphics.drawImage(spriteBank.SIDE4,(i % mapLength) * 16, (i / mapLength) * 16, game_View);
                    break;
                case 9:
                    graphics.drawImage(spriteBank.FENCE,(i % mapLength) * 16, (i / mapLength) * 16, game_View);
                    break;
                case 10:
                    graphics.drawImage(spriteBank.CORNFLOOR,(i % mapLength) * 16, (i / mapLength) * 16, game_View);
                    break;
            }
        }
    }
    private void drawChicken(Graphics2D graphics){
        if(gameManager.getCtrlDirX() == -1) {
            graphics.drawImage(spriteBank.CHICKEN_LEFT, gameManager.getChickenPosX(), gameManager.getChickenPosY(), game_View);
        } else if (gameManager.getCtrlDirX() == 1) {
            graphics.drawImage(spriteBank.CHICKEN_RIGHT, gameManager.getChickenPosX(), gameManager.getChickenPosY(), game_View);
        } else if (gameManager.getCtrlDirY() == -1) {
            graphics.drawImage(spriteBank.CHICKEN_DOWN, gameManager.getChickenPosX(), gameManager.getChickenPosY(), game_View);
        } else {
            graphics.drawImage(spriteBank.CHICKEN_UP, gameManager.getChickenPosX(), gameManager.getChickenPosY(), game_View);
        }
    }
    private void drawFoxes(Graphics2D graphics){
        graphics.drawImage(spriteBank.ORANGEFOX_RIGHT, gameManager.getOFoxPosX(), gameManager.getOFoxPosY(), game_View);
        graphics.drawImage(spriteBank.REDFOX_RIGHT, gameManager.getRFoxPosX(), gameManager.getRFoxPosY(), game_View);
        graphics.drawImage(spriteBank.PINKFOX_RIGHT, gameManager.getPFoxPosX(), gameManager.getPFoxPosY(), game_View);
        graphics.drawImage(spriteBank.CYANFOX_RIGHT, gameManager.getCFoxPosX(), gameManager.getCFoxPosY(), game_View);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        game_View.repaint();
        if(game_View.getItem1() == event.getSource()){
            runningGame = false;
            paused = false;
            gameManager.newGame();
            gameManager.initNewLevel();
        }
        if(game_View.getItem2() == event.getSource()){
            runningGame = false; 
            paused = true;
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
            if (runningGame) {
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
                    runningGame = false; 
                    paused = true;
                    gameManager.getTimer().stop();
                }
            } else {
                if (key == KeyEvent.VK_SPACE) {
                    if(paused){
                        runningGame = true;
                        paused = false;
                    gameManager.getTimer().start();
                    }else{
                        runningGame = true;
                        gameManager.newGame();
                        gameManager.initNewLevel();
                    }
                }
            }
        }
    }
}
