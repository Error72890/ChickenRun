package Model;

public class OrangeFox extends Fox{
    private static final int SPEED = 1;
    
    public OrangeFox(int homeX, int homeY, int initPosX, int initPosY){
        super(homeX, homeY, initPosX, initPosY);
    }
    
    public void pathFindingPersonality(int chickenX, int chickenY){
        int desX;
        int desY;
        int distanceFromMe = Math.abs(chickenX - getCellPosX()) + Math.abs(chickenY - getCellPosY());
        if (distanceFromMe <= 8) {
            changeMode("Chase");
        }else{
            changeMode("Scatter");
        }
        if(getMode().equals("Chase")){
            desX = chickenX;
            desY = chickenY;
            if(getCellPosX() == desX && getCellPosY() == desY + 1){
                setDirX(0);
                setDirY(-1);
            }else if(getCellPosX() == desX && getCellPosY() == desY - 1){
                setDirX(0);
                setDirY(1);
            }else if(getCellPosY() == desY && getCellPosX() == desX + 1){
                setDirX(-1);
                setDirY(0);
            }else if(getCellPosY() == desY && getCellPosX() == desX - 1){
                setDirX(1);
                setDirY(0);
            }else{
                mindMap[desX][desY] = 'D';
                changeDirection();
                mindMap[desX][desY] = '1';
            }
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
