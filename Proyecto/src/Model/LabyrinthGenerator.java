package Model;

public class LabyrinthGenerator {
    private static final int LABYRINTHSIZE = 25;
    private String[] labyrinth;
    
    private void generate(){
        String[] newLabyrinth = new String[LABYRINTHSIZE];;
        //Some algorithm
        //. . .
        labyrinth = newLabyrinth;
    }
    
    public String[] getNewLabyrinth(){
        generate();
        return labyrinth;
    }
}
