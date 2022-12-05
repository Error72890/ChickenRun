package Model;

import Util.CSVWriteReader;

public class ScoreManager {
    private static final short MAX_STORED_SCORES = 5;
    private static final String DOC_PATH= "src/Data/Scores.txt";
    private final CSVWriteReader csvWriteReader;
    
    public ScoreManager(){
        csvWriteReader = CSVWriteReader.getInstance();
    }
    
    public String[][] getScores(){
        String[][] scores = new String[MAX_STORED_SCORES][2];
        String[][] readedData = csvWriteReader.readFrom(DOC_PATH);
        int index;
        for(index = 0; index < MAX_STORED_SCORES; index++){
            try{
                System.arraycopy(readedData[index], 0, scores[index], 0, 2);
            }catch(Exception e){
                scores[index][0] = "Empty";
                scores[index][1] = "0";
            }
        }
        return scores;
    }
    
    public boolean addScore(String playerName, int newScore){
        String[][] scores = getScores();
        boolean updated = false;
        int i;
        for(i = 0; i < MAX_STORED_SCORES; i++){
            if(newScore >= Integer.parseInt(scores[i][1])){
                updated = true;
                int j;
                for (j = MAX_STORED_SCORES; j > i; j--) {
                    scores[j][0] = scores[j - 1][0];
                    scores[j][1] = scores[j - 1][1];
                }
                scores[i][0] = playerName;
                scores[i][1] = Integer.toString(newScore);
                csvWriteReader.writeTo(DOC_PATH, scores);
                break;
            }
        }
        return updated;
    }
}
