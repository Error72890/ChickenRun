package Controller;

import Model.GameManager;
import Model.ScoreManager;
import Util.SpriteBank;
import View.Game_View;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class GamePanel extends JComponent{
    private static final long serialVersionUID = 1L;
    private Game_View game_View;
    private final GameManager gameManager;
    private final SpriteBank spriteBank;
    private final ScoreManager scoreManager;
    private boolean runningGame;
    private boolean paused;
    private boolean ended;

    private final Font smallFont = new Font("Arial", Font.BOLD, 14);
    private final Font bigFont = new Font("Arial", Font.BOLD, 30);
    private final int mapLength;
    private final int screenSize;
    private static final int INFO_SIZE = 40;

    public GamePanel(GameManager gameManager, Game_View game_View) {
        super();      
        this.gameManager = gameManager;  
        this.game_View = game_View;
        this.spriteBank = SpriteBank.getInstance();
        this.scoreManager = new ScoreManager();
        mapLength = gameManager.getMapLength();
        screenSize = gameManager.getBlockSize() * mapLength;
        runningGame = false;
        paused = false;
        ended = false;
        this.setLocation(0, 0);
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
            if (paused) {
                drawChicken(graphics);
                drawFoxes(graphics);
                showPauseScreen(graphics);
            } else {
                if (gameManager.getLives() != 0) {
                    showIntroScreen(graphics);
                }else{
                    ended = true;
                    runningGame = false;
                    showDeathScreen(graphics);
                    if(scoreManager.addScore("Me", gameManager.getScore())){
                        showScoreSendedScreen(graphics);
                    }
                }
            }
        }
        Toolkit.getDefaultToolkit().sync();
        graphics.dispose();
    }
    
    
    private void playGame(Graphics2D graphics) {
        gameManager.update();
        if (gameManager.getLives() == 0) {
            runningGame = false;
        }
        if (!gameManager.isCatched()) {
            if(gameManager.allPointsRecolected()){
                runningGame = false;
            }else{
                drawChicken(graphics);
                drawFoxes(graphics);   
            }   
        }
    }
    
    private void showIntroScreen(Graphics2D graphics) {
        graphics.setFont(smallFont);
        graphics.setColor(Color.white);
    	String start = "Press SPACE to start";
        graphics.drawString(start, (screenSize)/4, 150);
    }  
    private void showDeathScreen(Graphics2D graphics) {
        graphics.setFont(bigFont);
        graphics.setColor(Color.red);
    	String start = "Game Over";
        graphics.drawString(start, (screenSize)/4, 150);
    }  
    private void showScoreSendedScreen(Graphics2D graphics) {
        graphics.setFont(bigFont);
        graphics.setColor(Color.yellow);
    	String start = "SCORE SENDED";
        graphics.drawString(start, (screenSize)/4, 100);
    }  
    private void showPauseScreen(Graphics2D graphics) {
        graphics.setFont(bigFont);
        graphics.setColor(Color.yellow);
    	String title = "Paused";
        graphics.drawString(title, (screenSize)/3, 150);
        graphics.setFont(smallFont);
        graphics.setColor(Color.white);
    	String start = "Press SPACE to Continue";
        graphics.drawString(start, (screenSize)/5, 175);
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
        if(gameManager.getOFoxDirX() == 1){
            graphics.drawImage(spriteBank.ORANGEFOX_RIGHT, gameManager.getOFoxPosX(), gameManager.getOFoxPosY(), game_View);
        }else{
            graphics.drawImage(spriteBank.ORANGEFOX_LEFT, gameManager.getOFoxPosX(), gameManager.getOFoxPosY(), game_View);
        }
        if(gameManager.getRFoxDirX() == 1){
            graphics.drawImage(spriteBank.REDFOX_RIGHT, gameManager.getRFoxPosX(), gameManager.getRFoxPosY(), game_View);
        }else{
            graphics.drawImage(spriteBank.REDFOX_LEFT, gameManager.getRFoxPosX(), gameManager.getRFoxPosY(), game_View);
        }
        if(gameManager.getPFoxDirX() == 1){
            graphics.drawImage(spriteBank.PINKFOX_RIGHT, gameManager.getPFoxPosX(), gameManager.getPFoxPosY(), game_View);
        }else{
            graphics.drawImage(spriteBank.PINKFOX_LEFT, gameManager.getPFoxPosX(), gameManager.getPFoxPosY(), game_View);
        }
        if(gameManager.getCFoxDirX() == 1){
            graphics.drawImage(spriteBank.CYANFOX_RIGHT, gameManager.getCFoxPosX(), gameManager.getCFoxPosY(), game_View);
        }else{
            graphics.drawImage(spriteBank.CYANFOX_LEFT, gameManager.getCFoxPosX(), gameManager.getCFoxPosY(), game_View);
        }
    }
    public boolean isRunningGame(){
        return runningGame;
    }
    public void setRunningGame(boolean arg){
        this.runningGame = arg;
    }
    public boolean isPaused(){
        return paused;
    }
    public void setPaused(boolean arg){
        this.paused = arg;
    }
    public boolean isEnded(){
        return ended;
    }
    public void setEnded(boolean arg){
        this.ended = arg;
    }
}

    