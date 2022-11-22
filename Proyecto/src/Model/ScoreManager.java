package Model;

import Util.CSVWriteReader;
import javax.swing.JTable;

public class ScoreManager {
    private CSVWriteReader CSVReader;
    
    public ScoreManager(){
        CSVReader = new CSVWriteReader();
    }
    
    public String[][] getScores(){
        String[][] scores = new String[5][2];
        String[][] readedData = CSVReader.readFrom("src/Data/Scores.txt");
        for(int i=0; i<5; i++){
            for(int j=0; j<2; j++){
                scores[i][j] = readedData[i][j];
            }
        }
        return scores;
    }
}
