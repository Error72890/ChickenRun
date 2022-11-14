package Model;

import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class GameManager {
    private final int BLOCKS_NUMBER = 19;
    private Chicken chicken;
    private int lives, score;
    private boolean catched = false;
    private Timer timer;
    private short[] currentScreenData;
    //Control reqs
    private int ctrlDirX, ctrlDirY;
    
    /*
        0 = empty;
        1 = esquina superior izquierda
        2 = paredes superiores
        3 = esquina superior derecha
        4 = paredes derecha
        5 = esquina inferior derecha
        6 = paredes abajo
        7 = esquina inferior izquierda
        8 = paredes izquierda
        9 = paredes interiores
        10 = casillas con maiz
        
        El centro y las esquinas donde van los zorros quedan en 0, todo lo demás que no sea una 
        pared de algún tipo es 1
    
        Ejemplo sin terminar:
    */
    public final short levelData[] ={
        1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3,
        8,0,10,10,10,10,10,10,9,10,10,10,10,10,10,10,10,0,4,
        8,10,9,9,9,9,9,10,9,10,9,9,9,9,9,9,9,10,4,
        8,10,10,9,10,10,9,10,9,10,9,10,10,10,10,10,9,10,4,
        8,9,10,10,10,10,10,10,10,10,9,10,9,9,9,10,9,10,4,
        8,9,9,9,9,9,9,9,9,10,10,10,10,10,9,10,9,10,4,
        8,10,10,10,9,10,10,10,10,10,9,9,9,10,9,10,10,10,4,
        8,10,9,10,10,10,9,9,9,10,10,10,10,10,10,10,9,10,4,
        8,10,10,10,9,10,10,10,9,9,9,10,9,9,9,9,9,10,4,
        8,9,9,9,9,9,9,10,10,0,9,10,10,10,10,10,10,10,4,
        8,10,10,10,10,10,9,10,9,10,10,10,9,9,9,9,10,9,4,
        8,10,9,10,9,10,10,10,9,10,9,9,9,10,10,10,10,10,4,
        8,10,9,10,9,9,9,10,9,10,9,10,10,10,9,9,9,10,4,
        8,10,9,10,9,10,10,10,9,10,10,10,9,10,10,10,9,10,4,
        8,10,9,10,9,10,9,10,9,9,9,9,9,10,9,10,9,10,4,
        8,10,9,10,10,10,9,10,10,10,10,10,10,10,9,10,9,10,4,
        8,10,9,9,9,9,9,10,9,9,9,9,9,10,9,10,9,10,4,
        8,0,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,0,4,
        7,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,5,
    };
    
    public void initVariables(ActionListener al){
        chicken = new Chicken();
        currentScreenData = new short[BLOCKS_NUMBER * BLOCKS_NUMBER];
        timer = new Timer(40, al);
        timer.start();
    }
    public void newGame() {
    	lives = 3;
        score = 0;
    }
    public void initNewLevel() {
        int i;
        for (i = 0; i < BLOCKS_NUMBER * BLOCKS_NUMBER; i++) {
            currentScreenData[i] = levelData[i];
        }
        resetPlayerDirPos();
    }
    public void update(){
        if (catched) {
            death();
        }else {
            //moveChicken();
            //checkSorroundings();
        }
    }
    
    private void death() {
        decrementLives();
        resetPlayerDirPos();
    }
    
    public void resetPlayerDirPos() {
        chicken.setPosX(9);
        chicken.setPosY(9);
        chicken.setDirX(0);
        chicken.setDirY(0);
        ctrlDirX = 0;	
        ctrlDirY = 0;
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
