package Controller;

import Model.ScoreManager;
import View.ScoreTable_View;
import javax.swing.JTable;

public class ScoreTable_Controller {
    private ScoreTable_View scoreTable_View;
    private ScoreManager score;
    
    ScoreTable_Controller(ScoreTable_View scoreTable_View) {
        this.scoreTable_View = scoreTable_View;
        score = new ScoreManager();
        updateTable();
    }
    
    private void updateTable(){
        JTable table = scoreTable_View.getTable();
        String[][] scoreData = score.getScores();
        for(int i=0; i<5; i++){
            for(int j=0; j<2; j++){
                table.setValueAt(scoreData[i][j], i, j);
            }
        }
    }
}
