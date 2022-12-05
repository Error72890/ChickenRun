package Model;

import java.awt.event.ActionListener;
import javax.swing.Timer;

public class GameManager {
    private static final int CELL_SIZE = 16;
    private static final int MAP_LENGTH = 19;
    private final Chicken chicken;
    private final OrangeFox clyde;
    private final RedFox blinky;
    private final pinkFox pinky;
    private final cyanFox inky;
    private int lives;
    private int score;
    private final Timer timer;
    private int inGameTime;
    private short[] currentScreenData;
    private int ctrlDirX;
    private int ctrlDirY;
    
    public GameManager(ActionListener al){
        chicken = new Chicken();
        clyde = new OrangeFox(1,1, 1*CELL_SIZE, 1*CELL_SIZE);
        blinky = new RedFox(1,17, 1*CELL_SIZE, 17*CELL_SIZE);
        pinky = new pinkFox(17,1, 17*CELL_SIZE, 1*CELL_SIZE);
        inky = new cyanFox(17,17, 17*CELL_SIZE, 17*CELL_SIZE);
        currentScreenData = new short[MAP_LENGTH * MAP_LENGTH];
        timer = new Timer(20, al);
        timer.start();
        inGameTime = 0;
    }
    public void newGame() {
    	lives = 3;
        score = 0;
    }
    public void initNewLevel() {
        LabyrinthGenerator lg = new LabyrinthGenerator();
        currentScreenData = lg.getNewLabyrinth();
        resetPlayerDirPos();
        clyde.resetCellPos(1*CELL_SIZE, 1*CELL_SIZE);
        clyde.resetDir();
        clyde.setNewMapData(currentScreenData);
        blinky.resetCellPos(1*CELL_SIZE, 17*CELL_SIZE);
        blinky.resetDir();
        blinky.setNewMapData(currentScreenData);
        pinky.resetCellPos(17*CELL_SIZE, 1*CELL_SIZE);
        pinky.resetDir();
        pinky.setNewMapData(currentScreenData);
        inky.resetCellPos(17*CELL_SIZE, 17*CELL_SIZE);
        inky.resetDir();
        inky.setNewMapData(currentScreenData);
        inGameTime = 0;
    }
    public void update(){
        inGameTime++;
        if(inGameTime <= 4000){
            String mode1 = "Chase";
            String mode2 = "Scatter";
            switch(inGameTime){
                case (1):
                    changeFoxesMode(mode1);
                    break;
                case (8000):
                    changeFoxesMode(mode2);
                    break;
                case (1500):
                    changeFoxesMode(mode1);
                    break;
                case (2500):
                    changeFoxesMode(mode2);
                    break;
                case (3000):
                    changeFoxesMode(mode1);
                    break;
                case (3500):
                    changeFoxesMode(mode2);
                    break;
                case (4000):
                    changeFoxesMode(mode1);
                    break;
                default:
                    break;

            }
        }
        if(allPointsRecolected()){
            initNewLevel();
        }else if (isCatched()) {
            death();
        }else {
            moveFoxes();
            moveChicken();
        }
    }
    public boolean allPointsRecolected(){
        int index;
        for(index=0; index < currentScreenData.length; index++){
            if(currentScreenData[index] == 10){
                return false;
            }
        }
        return true;
    }
    public boolean isCatched(){
        return ((chicken.getPosX()==clyde.getPosX() && chicken.getPosY()==clyde.getPosY()) || (chicken.getPosX()==blinky.getPosX() && chicken.getPosY()==blinky.getPosY()) || (chicken.getPosX()==pinky.getPosX() && chicken.getPosY()==pinky.getPosY()) || (chicken.getPosX()==inky.getPosX() && chicken.getPosY()==inky.getPosY())) 
                || ((chicken.getPosX()+1==clyde.getPosX() && chicken.getPosY()==clyde.getPosY()) || (chicken.getPosX()+1==blinky.getPosX() && chicken.getPosY()==blinky.getPosY()) || (chicken.getPosX()+1==pinky.getPosX() && chicken.getPosY()==pinky.getPosY()) || (chicken.getPosX()+1==inky.getPosX() && chicken.getPosY()==inky.getPosY()))
                || ((chicken.getPosX()-1==clyde.getPosX() && chicken.getPosY()==clyde.getPosY()) || (chicken.getPosX()-1==blinky.getPosX() && chicken.getPosY()==blinky.getPosY()) || (chicken.getPosX()-1==pinky.getPosX() && chicken.getPosY()==pinky.getPosY()) || (chicken.getPosX()-1==inky.getPosX() && chicken.getPosY()==inky.getPosY()))
                || ((chicken.getPosX()==clyde.getPosX() && chicken.getPosY()+1==clyde.getPosY()) || (chicken.getPosX()==blinky.getPosX() && chicken.getPosY()+1==blinky.getPosY()) || (chicken.getPosX()==pinky.getPosX() && chicken.getPosY()+1==pinky.getPosY()) || (chicken.getPosX()==inky.getPosX() && chicken.getPosY()+1==inky.getPosY()))
                || ((chicken.getPosX()==clyde.getPosX() && chicken.getPosY()-1==clyde.getPosY()) || (chicken.getPosX()==blinky.getPosX() && chicken.getPosY()-1==blinky.getPosY()) || (chicken.getPosX()==pinky.getPosX() && chicken.getPosY()-1==pinky.getPosY()) || (chicken.getPosX()==inky.getPosX() && chicken.getPosY()-1==inky.getPosY()));
    }
    
    private void death() {
        decrementLives();
        resetPlayerDirPos();
        clyde.resetCellPos(1*CELL_SIZE, 1*CELL_SIZE);
        blinky.resetCellPos(1*CELL_SIZE, 17*CELL_SIZE);
        pinky.resetCellPos(17*CELL_SIZE, 1*CELL_SIZE);
        inky.resetCellPos(17*CELL_SIZE, 17*CELL_SIZE);
        inGameTime = 0;
    }
    
    public void resetPlayerDirPos() {
        chicken.setPosX(9 * CELL_SIZE);
        chicken.setPosY(9 * CELL_SIZE);
        chicken.setDirX(0);
        chicken.setDirY(0);
        ctrlDirX = 0;	
        ctrlDirY = 0;
    }
    
    private void moveChicken() {
        if (playerOnExactCell()) {
            int posInArray = chicken.getPosX() / CELL_SIZE + MAP_LENGTH * (int) (chicken.getPosY() / CELL_SIZE);
            short squareCurrent = currentScreenData[posInArray];
            short squareAbove = currentScreenData[posInArray - MAP_LENGTH];
            short squareBelow = currentScreenData[posInArray + MAP_LENGTH];
            short squareLeft = currentScreenData[posInArray - 1];
            short squareRight = currentScreenData[posInArray + 1];
            if (squareCurrent == 10) {
                currentScreenData[posInArray] = 0;
                score++;
            }
            if(canMoveToDir(squareAbove, squareBelow, squareLeft, squareRight)){
                if(ctrlDirX != 0 || ctrlDirY != 0){
                    chicken.setDirX(ctrlDirX);
                    chicken.setDirY(ctrlDirY);
                }
            }else{
                chicken.setDirX(0);
                chicken.setDirY(0);
            }
        } 
        chicken.setPosX(chicken.getPosX() + chicken.getSpeed() * chicken.getDirX());
        chicken.setPosY(chicken.getPosY () + chicken.getSpeed() * chicken.getDirY());
    }
    private boolean playerOnExactCell(){
        return (chicken.getPosX() % CELL_SIZE == 0 && chicken.getPosY() % CELL_SIZE == 0);
    }
    private boolean canMoveToDir(short squareAbove, short squareBelow, short squareLeft, short squareRight){
        return !((ctrlDirX == -1 && ctrlDirY == 0 && squareLeft != 0 && squareLeft != 10) || (ctrlDirX == 1 && ctrlDirY == 0 && squareRight != 0 && squareRight != 10)
                || (ctrlDirX == 0 && ctrlDirY == -1 && squareAbove != 0 && squareAbove != 10) || (ctrlDirX == 0 && ctrlDirY == 1 && squareBelow != 0 && squareBelow != 10));
    }
    
    private void moveFoxes() {
        if (foxesOnExactCell(clyde)) {
            clyde.setCellX(clyde.getPosX() / CELL_SIZE);
            clyde.setCellY(clyde.getPosY() / CELL_SIZE);
            clyde.pathFindingPersonality(chicken.getPosX() / CELL_SIZE, chicken.getPosY() / CELL_SIZE);
        }
        if (foxesOnExactCell(blinky)) {
            blinky.setCellX(blinky.getPosX() / CELL_SIZE);
            blinky.setCellY(blinky.getPosY() / CELL_SIZE);
            blinky.pathFindingPersonality(chicken.getPosX() / CELL_SIZE, chicken.getPosY() / CELL_SIZE);
        }
        if (foxesOnExactCell(pinky)) {
            pinky.setCellX(pinky.getPosX() / CELL_SIZE);
            pinky.setCellY(pinky.getPosY() / CELL_SIZE);
            pinky.pathFindingPersonality(chicken.getPosX() / CELL_SIZE, chicken.getPosY() / CELL_SIZE, chicken.getLastFacedX(), chicken.getLastFacedY());
        }
        if (foxesOnExactCell(inky)) {
            inky.setCellX(inky.getPosX() / CELL_SIZE);
            inky.setCellY(inky.getPosY() / CELL_SIZE);
            inky.pathFindingPersonality(chicken.getPosX() / CELL_SIZE, inky.getPosY() / CELL_SIZE, blinky.getCellPosX(), blinky.getCellPosY(), pinky.getCellPosX(), pinky.getCellPosY());
        }
        clyde.setPosX(clyde.getPosX() + clyde.getSpeed() * clyde.getDirX());
        clyde.setPosY(clyde.getPosY() + clyde.getSpeed() * clyde.getDirY());
        blinky.setPosX(blinky.getPosX() + blinky.getSpeed() * blinky.getDirX());
        blinky.setPosY(blinky.getPosY() + blinky.getSpeed() * blinky.getDirY());
        pinky.setPosX(pinky.getPosX() + pinky.getSpeed() * pinky.getDirX());
        pinky.setPosY(pinky.getPosY() + pinky.getSpeed() * pinky.getDirY());
        inky.setPosX(inky.getPosX() + inky.getSpeed() * inky.getDirX());
        inky.setPosY(inky.getPosY() + inky.getSpeed() * inky.getDirY());
    }
    private boolean foxesOnExactCell(Fox fox){
        return (fox.getPosX() % CELL_SIZE == 0 && fox.getPosY() % CELL_SIZE == 0);
    }
    public void changeFoxesMode(String newMode){
        clyde.setMode(newMode);
        blinky.setMode(newMode);
        pinky.setMode(newMode);
        inky.setMode(newMode);
    }
    public int getBlockSize(){
        return CELL_SIZE;
    } 
    public int getMapLength(){
        return MAP_LENGTH;
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
    public int getOFoxPosX(){
        return clyde.getPosX();
    }
    public int getOFoxPosY(){
        return clyde.getPosY();
    }
    public int getOFoxDirX(){
        return clyde.getDirX();
    }
    public int getRFoxPosX(){
        return blinky.getPosX();
    }
    public int getRFoxPosY(){
        return blinky.getPosY();
    }
    public int getRFoxDirX(){
        return blinky.getDirX();
    }
    public int getPFoxPosX(){
        return pinky.getPosX();
    }
    public int getPFoxPosY(){
        return pinky.getPosY();
    }
    public int getPFoxDirX(){
        return pinky.getDirX();
    }
    public int getCFoxPosX(){
        return inky.getPosX();
    }
    public int getCFoxPosY(){
        return inky.getPosY();
    }
    public int getCFoxDirX(){
        return inky.getDirX();
    }
}
