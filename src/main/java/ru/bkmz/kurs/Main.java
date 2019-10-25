package ru.bkmz.kurs;

import javafx.application.Application;
import javafx.stage.Stage;
import ru.bkmz.kurs.util.StageStandart;

public class Main extends Application {

    public static StageStandart stageStandart;
    public static Stage stage;

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        setUserAgentStylesheet(STYLESHEET_CASPIAN);
        stageStandart = new StageStandart("main", false,
                stage, "kurs");
        stage = stageStandart.getStage();
        stage.setMinWidth(881);
        stage.setMinHeight(242);
        Main.stageStandart.getStage().setMaxHeight(399);

    }
}
