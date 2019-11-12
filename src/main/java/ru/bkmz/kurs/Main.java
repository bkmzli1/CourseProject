package ru.bkmz.kurs;

import ru.bkmz.kurs.util.stage.StageStandart;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {

    public static StageStandart stageStandart;
    public static Stage stage;
    //FIXME

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
        setUserAgentStylesheet(STYLESHEET_CASPIAN);
        stageStandart = new StageStandart("main", false,
                stage, "HR calculator");
        Main.stage = stageStandart.getStage();
        Main.stage.setMinWidth(806.0f);
        Main.stage.setMinHeight(420.0f);
    }
}