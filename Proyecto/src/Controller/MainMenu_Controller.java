    package Controller;

import View.Game_View;
import View.MainMenu_View;
import View.ScoreTable_View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu_Controller implements ActionListener{
    private MainMenu_View mainMenu_View;

    public MainMenu_Controller(MainMenu_View MainMenu_View){
        this.mainMenu_View = MainMenu_View;
        this.mainMenu_View.getStartBtn().addActionListener(this);
        this.mainMenu_View.getScoreBtn().addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent event) {
        if(mainMenu_View.getStartBtn() == event.getSource()){
            Game_View game_View = new Game_View();
            Game_Controller game_Controller = new Game_Controller(game_View);
            game_View.setLocationRelativeTo(null);
            game_View.setVisible(true);
            this.mainMenu_View.dispose();
        }if(mainMenu_View.getScoreBtn() == event.getSource()){
            ScoreTable_View scoreTable_View = new ScoreTable_View();
            ScoreTable_Controller scoreTable_Controller = new ScoreTable_Controller(scoreTable_View);
            scoreTable_View.setLocationRelativeTo(null);
            scoreTable_View.setVisible(true);
        }
    }
}
