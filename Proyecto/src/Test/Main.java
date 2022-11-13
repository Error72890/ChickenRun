package Test;

import Controller.MainMenu_Controller;
import View.MainMenu_View;

public class Main {

    public static void main(String args[]) {
        MainMenu_View mainMenu_View = new MainMenu_View();
        MainMenu_Controller mainMenu_Controller = new MainMenu_Controller(mainMenu_View);
        mainMenu_View.setLocationRelativeTo(null);
        mainMenu_View.setVisible(true);
    }
}
