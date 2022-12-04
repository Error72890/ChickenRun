package Model;

public class Node {
    private final int x;
    private final int y;
    private final int distanceFromSource;

    Node(int x, int y, int dis) {
        this.x = x;
        this.y = y;
        this.distanceFromSource = dis;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public int getDistanceFromSource(){
        return distanceFromSource;
    }
}