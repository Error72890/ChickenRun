package Util;

import java.awt.Image;
import javax.swing.ImageIcon;

public class SpriteBank {
    private static SpriteBank instance;
    
    public static final Image CLEARFLOOR = new ImageIcon("src/Sprites/Clean.gif").getImage();
    public static final Image CORNER1 = new ImageIcon("src/Sprites/Corner1.gif").getImage();
    public static final Image CORNER2 = new ImageIcon("src/Sprites/Corner2.gif").getImage();
    public static final Image CORNER3 = new ImageIcon("src/Sprites/Corner3.gif").getImage();
    public static final Image CORNER4 = new ImageIcon("src/Sprites/Corner4.gif").getImage();
    public static final Image SIDE1 = new ImageIcon("src/Sprites/Side1.gif").getImage();
    public static final Image SIDE2 = new ImageIcon("src/Sprites/Side2.gif").getImage();
    public static final Image SIDE3 = new ImageIcon("src/Sprites/Side3.gif").getImage();
    public static final Image SIDE4 = new ImageIcon("src/Sprites/Side4.gif").getImage();
    public static final Image FENCE = new ImageIcon("src/Sprites/Fence.gif").getImage();
    public static final Image CORNFLOOR = new ImageIcon("src/Sprites/Corn.gif").getImage();
    
    public static final Image CHICKEN_UP = new ImageIcon("src/Sprites/Gallina_Abajo.gif").getImage();
    public static final Image CHICKEN_DOWN = new ImageIcon("src/Sprites/Gallina_Arriba.gif").getImage();
    public static final Image CHICKEN_LEFT = new ImageIcon("src/Sprites/Gallina_Izquierda.gif").getImage();
    public static final Image CHICKEN_RIGHT = new ImageIcon("src/Sprites/Gallina_Derecha.gif").getImage();
    
    public static final Image ORANGEFOX_RIGHT = new ImageIcon("src/Sprites/OFox_Right.gif").getImage();
    public static final Image REDFOX_RIGHT = new ImageIcon("src/Sprites/RFox_Right.gif").getImage();
    public static final Image PINKFOX_RIGHT = new ImageIcon("src/Sprites/PFox_Right.gif").getImage();
    public static final Image CYANFOX_RIGHT = new ImageIcon("src/Sprites/CFox_Right.gif").getImage();
    public static final Image ORANGEFOX_LEFT = new ImageIcon("src/Sprites/OFox_Left.gif").getImage();
    public static final Image REDFOX_LEFT = new ImageIcon("src/Sprites/RFox_Left.gif").getImage();
    public static final Image PINKFOX_LEFT = new ImageIcon("src/Sprites/PFox_Left.gif").getImage();
    public static final Image CYANFOX_LEFT = new ImageIcon("src/Sprites/CFox_Left.gif").getImage();
    
    private SpriteBank(){
        
    }
    
    public static SpriteBank getInstance(){
        if(instance == null){
            instance = new SpriteBank();
        }
        return instance;
    }
}
