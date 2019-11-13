package ru.bkmz.kurs;

import javafx.application.Application;
import javafx.stage.Stage;
import ru.bkmz.kurs.util.stage.StageStandart;


public class Main extends Application {

    public static Stage stage;

    public static void main(String[] args) {
        for (String arg :
                args) {
            System.out.println(arg + ":true");
        }
        launch(args);
    }


    @Override
    public void init() throws Exception {

    }

    @Override
    public void start(Stage stage) throws Exception {
        Main.stage = stage;
        setUserAgentStylesheet(STYLESHEET_CASPIAN);
        new StageStandart("main", false,
                stage, "HR calculator");
        Main.stage.setMinWidth(875.3333129882812d);
        Main.stage.setMinHeight(647.3333129882812d);
    }
}