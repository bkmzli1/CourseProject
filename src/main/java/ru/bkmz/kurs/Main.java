package ru.bkmz.kurs;

import javafx.application.Application;
import javafx.stage.Stage;
import ru.bkmz.kurs.util.Stage.StageStandart;

public class Main extends Application {

    public static StageStandart stageStandart;
    public static Stage stage;

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void init() throws Exception {


    }

    @Override
    public void start(Stage stage) throws Exception {
        setUserAgentStylesheet(STYLESHEET_CASPIAN);
        stageStandart = new StageStandart("main", false,
                stage, "kurs");
        stage = stageStandart.getStage();
        stage.setMinWidth(881);
        stage.setMinHeight(265);
        Main.stageStandart.getStage().setMaxHeight(399);

    }
}
