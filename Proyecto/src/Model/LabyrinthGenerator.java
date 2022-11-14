package Model;

public class LabyrinthGenerator {
    private static final int LABYRINTHSIZE = 19;
    private String[] labyrinth;
    
    private void generate(){
        String[] newLabyrinth = new String[LABYRINTHSIZE];;
    Random randon = new Random();
		int [][] matriz = new int [19][19];
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				matriz[i][j] = randon.nextInt(10);
			}
		}
    }
        labyrinth = newLabyrinth;
    }
    
    public String[] getNewLabyrinth(){
        generate();
        return labyrinth;
    }
}
