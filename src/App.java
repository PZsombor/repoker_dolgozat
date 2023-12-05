/*
* File: App.java
* Author: Nagy József
* Refactor: Paulusz Zsombor
* Github: https://github.com/PZsombor
* Copyright: 2021, Nagy József 
* Date: 2021-09-11
* Licenc: MIT
*
*/

import controllers.MainController;
import views.MainWindow;

public class App { 
    public static void main(String[] args) throws Exception { 
        MainWindow mainWindow = new MainWindow();
        new MainController(mainWindow);
        mainWindow.setVisible(true);
    }
}
