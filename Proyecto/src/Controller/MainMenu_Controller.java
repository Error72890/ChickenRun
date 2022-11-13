package Controller;

import View.MainMenu_View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu_Controller implements ActionListener{
    private MainMenu_View MainMenu_View;

    public MainMenu_Controller(MainMenu_View MainMenu_View){
        this.MainMenu_View = MainMenu_View;
        this.MainMenu_View.getStartBtn().addActionListener(this);
        this.MainMenu_View.getScoreBtn().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        if(MainMenu_View.getStartBtn() == evento.getSource()){
            
        }
    }
}
