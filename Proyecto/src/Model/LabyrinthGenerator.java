package Model;

public class LabyrinthGenerator {
    private static final int LABYRINTHSIZE = 19;
    private String[] labyrinth;
    
    private void generate(){
        String[] newLabyrinth = new String[LABYRINTHSIZE];;
    Random randon = new Random();
		int [][] labyrinth = new int [19][19];
		for (int i = 0; i < labyrinth.length; i++) {
			for (int j = 0; j < labyrinth.length; j++) {
                                if(i==0||i==18){
                                    labyrinth[i][j]=1;
                                }
                                else if(j==0||j==18){
                                    labyrinth[i][j]=1;
                                }
                                else labyrinth[i][j] = randon.nextInt(0,2);
			}
		}
        labyrinth = newLabyrinth;
    }
    
    public String[] getNewLabyrinth(){
        generate();
        return labyrinth;
    }
}
