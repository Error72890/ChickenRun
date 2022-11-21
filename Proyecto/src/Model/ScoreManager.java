package Model;

import Util.CSVWriteReader;
import javax.swing.JTable;

public class ScoreManager {
    private CSVWriteReader CSVReader;
    
    public ScoreManager(){
        CSVReader = new CSVWriteReader();
    }
    
    public String[][] getScores(){
        return CSVReader.readFrom("src/Data/Scores.txt");
    }
}
