package Model;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Chicken {
    private final int SPEED = 4;
    private Image up, down, left, right;
    private int posX, posY, dirX, dirY;
        
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
    }
    public void setDirY(int newDir){
        dirY = newDir;
    }
    public int getDirX(){
        return dirX;
    }
    public int getDirY(){
        return dirY;
    }
}
