package Model;

public class Chicken {
    public static final int SPEED = 2;
    private int posX;
    private int posY;
    private int dirX;
    private int dirY;
    private int lastFacedDirX;
    private int lastFacedDirY;
        
    public Chicken(){
        posX = 0;
        posY = 0;
        dirX = 0;
        dirY = 0;
        lastFacedDirX = 1;
        lastFacedDirY = 0;
    }
    
    public int getSpeed(){
        return SPEED;
    }
    public void setPosX(int newPos){
        posX = newPos;
    }
    public void setPosY(int newPos){
        posY = newPos;
    }
    public int getPosX(){
        return posX;
    }
    public int getPosY(){
        return posY;
    }
    public void setDirX(int newDir){
        dirX = newDir;
        if(dirX != 0){
            lastFacedDirX = dirX;
            lastFacedDirY = 0;
        }
    }
    public void setDirY(int newDir){
        dirY = newDir;
        if(dirY != 0){
            lastFacedDirX = 0;
            lastFacedDirY = dirY;
        }
    }
    public int getDirX(){
        return dirX;
    }
    public int getDirY(){
        return dirY;
    }
    public int getLastFacedX(){
        return lastFacedDirX;
    }
    public int getLastFacedY(){
        return lastFacedDirY;
    }
}
