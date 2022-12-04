package Model;

import static java.lang.Math.sqrt;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Fox {
    private final int homeCellX;
    private final int homeCellY;
    private String mode;
    private int posX;
    private int posY;
    private int dirX;
    private int dirY;
    private int cellPosX;
    private int cellPosY;
    protected char[][] mindMap;
    
    //Fox have 2 positions, the cell based, and the relative to screen size
    public Fox(int homeX, int homeY, int initPosX, int initPosY){
        this.homeCellX = homeX;
        this.homeCellY = homeY;
        this.posX = initPosX;
        this.posY = initPosY;
        this.mode = "Chase";
    }
    public void resetCellPos(int initPosX, int initPosY){
        this.posX = initPosX;
        this.posY = initPosY;
        this.cellPosX = homeCellX;
        this.cellPosY = homeCellY;
    }
    public void resetDir(){
        this.dirX = 0;
        this.dirY = 0;
    }
    public void setNewMapData(short[] map){
        int mapSize = (int) sqrt(map.length);
        mindMap = new char[mapSize][mapSize];
        int i;
        for(i=0; i<mapSize; i++){
            int j;
            for(j=0; j<mapSize; j++){
                if(map[(i*mapSize)+j] == 0 || map[(i*mapSize)+j] == 10){
                    mindMap[j][i] = '1';
                }else{
                    mindMap[j][i] = '0';
                }
            }
        }
    }
    public void changeMode(String mode){
        this.mode = mode;
    }
    protected void changeDirection(){
        if(canRotate() || onDeadEnd() || (getDirX() == 0 && getDirY() == 0)){
            switch (clockwisePathSelection()){
                case 1:
                    setDirX(0);
                    setDirY(-1);
                    break;
                case 2:
                    setDirX(1);
                    setDirY(0);
                    break;
                case 3:
                    setDirX(0);
                    setDirY(1);
                    break;
                case 4:
                    setDirX(-1);
                    setDirY(0);
                    break;
                default:
                    setDirX(0);
                    setDirY(0);
                    break; 
            }
        }
    }
    private boolean canRotate(){
        return ((dirX != 0 && (mindMap[cellPosX][cellPosY-1] == '1' || mindMap[cellPosX][cellPosY+1] == '1')) || (dirY != 0 && (mindMap[cellPosX-1][cellPosY] == '1' || mindMap[cellPosX+1][cellPosY] == '1')));
    }
    private boolean onDeadEnd(){
        return ((dirY == -1 && mindMap[cellPosX][cellPosY-1] == '0') || (dirX == 1 && mindMap[cellPosX + 1][cellPosY] == '0') || (dirY == 1 && mindMap[cellPosX][cellPosY+1] == '0') || (dirX == -1 && mindMap[cellPosX - 1][cellPosY] == '0')          );
    }
    private int clockwisePathSelection(){
        int best = 0;
        int smallestDistance = 999;
        int distance;
        if (mindMap[cellPosX][cellPosY - 1] == '1') {
            distance = getShortPath(cellPosX, cellPosY - 1);
            if (distance < smallestDistance) {
                smallestDistance = distance;
                best = 1;
            }
        }
        if (mindMap[cellPosX + 1][cellPosY] == '1') {
            distance = getShortPath(cellPosX + 1, cellPosY);
            if (distance < smallestDistance) {
                smallestDistance = distance;
                best = 2;
            }
        }
        if (mindMap[cellPosX][cellPosY + 1] == '1') {
            distance = getShortPath(cellPosX, cellPosY + 1);
            if (distance < smallestDistance) {
                smallestDistance = distance;
                best = 3;
            }
        }
        if (mindMap[cellPosX - 1][cellPosY] == '1') {
            distance = getShortPath(cellPosX - 1, cellPosY);
            if (distance < smallestDistance) {
                best = 4;
            }
        }
        return best;
    }
    private int getShortPath(int initCellX, int initCellY) {
    //Using Breath First Search Arlgorithm 
        char[][] mapClone = new char[mindMap.length][mindMap.length];
        for(int i=0; i<mapClone.length; i++){
            System.arraycopy(mindMap[i], 0, mapClone[i], 0, mapClone.length);
        }
        Node source = new Node(initCellX, initCellY, 0);
        Deque<Node> queue = new LinkedList<>();
        queue.add(source);
        
        while (!queue.isEmpty()) {
            Node poped = queue.poll();

            if (mapClone[poped.getX()][poped.getY()] == 'D') { 
                return poped.getDistanceFromSource();
            } else {
                mapClone[poped.getX()][poped.getY()] = '0';

                List<Node> neighbourList = addNeighbours(poped, mapClone);
                queue.addAll(neighbourList);
            }
        }
        return 999;
    }

    private List<Node> addNeighbours(Node poped, char[][] matrix) {
        List<Node> list = new LinkedList<>();
        if (matrix[poped.getX()][poped.getY() - 1] != '0') {
            list.add(new Node(poped.getX(), poped.getY() - 1, poped.getDistanceFromSource() + 1));
        }
        if (matrix[poped.getX() + 1][poped.getY()] != '0') {
            list.add(new Node(poped.getX() + 1, poped.getY(), poped.getDistanceFromSource() + 1));
        }
        if (matrix[poped.getX()][poped.getY() + 1] != '0') {
            list.add(new Node(poped.getX(), poped.getY() + 1, poped.getDistanceFromSource() + 1));
        }
        if (matrix[poped.getX() - 1][poped.getY()] != '0') {
            list.add(new Node(poped.getX() - 1, poped.getY(), poped.getDistanceFromSource() + 1));
        }
        return list;
    }
    public int getHomeCellX(){
        return homeCellX;
    }
    public int getHomeCellY(){
        return homeCellY;
    }
    public String getMode(){
        return mode;
    }
    public void setMode(String mode){
        this.mode = mode;
    }
    public void setPosX(int newPos){
        posX = newPos;
    }
    public void setPosY(int newPos){
        posY = newPos;
    }
    public void setCellX(int newPos){
        cellPosX = newPos;
    }
    public void setCellY(int newPos){
        cellPosY = newPos;
    }
    public int getPosX(){
        return posX;
    }
    public int getPosY(){
        return posY;
    }
    public void setDirX(int dirX){
       this.dirX = dirX;
    }
    public int getDirX(){
        return dirX;
    }
    public void setDirY(int dirY){
       this.dirY = dirY;
    }
    public int getDirY(){
        return dirY;
    }
    public int getCellPosX(){
        return cellPosX;
    }
    public int getCellPosY(){
        return cellPosY;
    }
}
