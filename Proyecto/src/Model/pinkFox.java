package Model;

public class pinkFox extends Fox{
    private static final int SPEED = 1;
    public pinkFox(int homeX, int homeY, int initPosX, int initPosY){
        super(homeX, homeY, initPosX, initPosY);
    }
    
    public void pathFindingPersonality(int chickenX, int chickenY, int chickenDirX, int chickenDirY){
        if(getMode().equals("Chase")){
            int i = 4;
            do{
                try{
                    if(mindMap[chickenX + (chickenDirX * i)][chickenY + (chickenDirY * i)] != '1'){
                        i--;
                    }else{
                        mindMap[chickenX + (chickenDirX * i)][chickenY + (chickenDirY * i)] = 'D';
                        changeDirection();
                        mindMap[chickenX + (chickenDirX * i)][chickenY + (chickenDirY * i)] = '1';
                        i = -1;
                    }
                }catch(Exception e){
                    i--;
                }
            }while(i != -1);
        }else{
            mindMap[getHomeCellX()][getHomeCellY()] = 'D';
            changeDirection();
            mindMap[getHomeCellX()][getHomeCellY()] = '1';
        }
    }
    
    public int getSpeed(){
        return SPEED;
    }
}
