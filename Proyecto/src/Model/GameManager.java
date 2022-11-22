package Model;

import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class GameManager {
    private final int BLOCK_SIZE = 16;
    private final int BLOCKS_NUMBER = 19;
    private Chicken chicken;
    private int lives, score;
    private boolean catched;
    private Timer timer;
    private short[] currentScreenData;
    private int ctrlDirX, ctrlDirY;     //Control reqs
    
    short[] levelData;
    
    public void initVariables(ActionListener al){ //Considerar usar constructor
        chicken = new Chicken();
        currentScreenData = new short[BLOCKS_NUMBER * BLOCKS_NUMBER];
        catched = false;
        timer = new Timer(40, al);
        timer.start();
    }
    public void newGame() {
    	lives = 3;
        score = 0;
    }
    public void initNewLevel() {
        int i;
        LabyrinthGenerator lg = new LabyrinthGenerator();
        //levelData = lg.getNewLabyrinth();
        levelData = lg.getPrefabLabyrinth();
        for (i = 0; i < BLOCKS_NUMBER * BLOCKS_NUMBER; i++) {
            currentScreenData[i] = levelData[i];
        }
        resetPlayerDirPos();
    }
    public void update(){
        if (catched) {
            death();
        }else {
            moveChicken();
            //checkIfLevelComplete();
        }
    }
    
    private void death() {
        decrementLives();
        resetPlayerDirPos();
    }
    
    public void resetPlayerDirPos() {
        chicken.setPosX(9 * BLOCK_SIZE);
        chicken.setPosY(9 * BLOCK_SIZE);
        chicken.setDirX(0);
        chicken.setDirY(0);
        ctrlDirX = 0;	
        ctrlDirY = 0;
    }
    
      private void moveChicken() {
        if (chicken.getPosX() % BLOCK_SIZE == 0 && chicken.getPosY() % BLOCK_SIZE == 0) {
            int posInArray = chicken.getPosX() / BLOCK_SIZE + BLOCKS_NUMBER * (int) (chicken.getPosY() / BLOCK_SIZE);
            short squareCurrent = currentScreenData[posInArray];
            short squareAbove = currentScreenData[posInArray - BLOCKS_NUMBER];
            short squareBelow = currentScreenData[posInArray + BLOCKS_NUMBER];
            short squareLeft = currentScreenData[posInArray - 1];
            short squareRight = currentScreenData[posInArray + 1];
            if (squareCurrent == 10) {
                currentScreenData[posInArray] = 0;
                score++;
            }
            if (ctrlDirX != 0 || ctrlDirY != 0) {
                if (!((ctrlDirX == -1 && ctrlDirY == 0 && squareLeft != 0 && squareLeft != 10)
                        || (ctrlDirX == 1 && ctrlDirY == 0 && squareRight != 0 && squareRight != 10)
                        || (ctrlDirX == 0 && ctrlDirY == -1 && squareAbove != 0 && squareAbove != 10)
                        || (ctrlDirX == 0 && ctrlDirY == 1 && squareBelow != 0 && squareBelow != 10))) {
                    chicken.setDirX(ctrlDirX);
                    chicken.setDirY(ctrlDirY);
                }
            }
            if ((chicken.getDirX() == -1 && chicken.getDirY() == 0 && squareLeft != 0 && squareLeft != 10)
                    || (chicken.getDirX() == 1 && chicken.getDirY() == 0 && squareRight != 0 && squareRight != 10)
                    || (chicken.getDirX() == 0 && chicken.getDirY() == -1 && squareAbove != 0 && squareAbove != 10)
                    || (chicken.getDirX()== 0 && chicken.getDirY() == 1 && squareBelow != 0 && squareBelow != 10)) {
                chicken.setDirX(0);
                chicken.setDirY(0);
            }
        } 
        chicken.setPosX(chicken.getPosX() + chicken.SPEED * chicken.getDirX());
        chicken.setPosY(chicken.getPosY () + chicken.SPEED * chicken.getDirY());
    }
      
    public void setLives(int amount){
        lives = amount;
    }
    public void decrementLives(){
        lives--;
    }
    public int getLives(){
        return lives;
    }
    public void setScore(int amount){
        score = amount;
    }
    public void incrementScore(int increment){
        score += increment;
    }
    public int getScore(){
        return score;
    }
    public boolean isCatched(){
        return catched;
    }
    public Timer getTimer(){
        return timer;
    }
    public short[] getScreenData(){
        return currentScreenData;
    }
    public void setCtrlDirX(int newDir){
        ctrlDirX = newDir;
    }
    public int getCtrlDirX(){
        return ctrlDirX;
    }
    public void setCtrlDirY(int newDir){
        ctrlDirY = newDir;
    }
    public int getCtrlDirY(){
        return ctrlDirY;
    }
    public int getChickenPosX(){
        return chicken.getPosX();
    }
    public int getChickenPosY(){
        return chicken.getPosY();
    }
}
