package Model;

import java.util.Random;

public class cyanFox extends Fox{
    private static final int SPEED = 1;
    private Random dice;
    public cyanFox(int homeX, int homeY, int initPosX, int initPosY){
        super(homeX, homeY, initPosX, initPosY);
        dice = new Random();
    }
    
    public void pathFindingPersonality(int chickenX, int chickenY, int redFoxX, int redFoxY, int pinkFoxX, int pinkFoxY){
        int desX;
        int desY;
        if(getMode().equals("Chase")){
            int rand = dice.nextInt(3);
            switch (rand) {
                case 0:
                    desX = chickenX;
                    desY = chickenY;
                    break;
                case 1:
                    desX = redFoxX;
                    desY = redFoxY;
                    break;
                default:
                    desX = pinkFoxX;
                    desY = pinkFoxY;
                    break;
            }
        }else{
            desX = getHomeCellX();
            desY = getHomeCellY();
        }
        mindMap[desX][desY] = 'D';
        changeDirection();
        mindMap[desX][desY] = '1';
    }
    
    public int getSpeed(){
        return SPEED;
    }
}
