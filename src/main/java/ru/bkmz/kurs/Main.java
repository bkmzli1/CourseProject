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
    public static int stringToInt(String s){
        return (s.charAt(0) == '-' ? -1 : 1) * s.substring(s.charAt(0) == '-' ? 1 :0)
                .chars()
                .reduce(0, (runningSum,c) -> runningSum * 10 + c -'0');
    }
    @Override
    public void init() throws Exception {


    }

    @Override
    public void start(Stage stage) throws Exception {
        setUserAgentStylesheet(STYLESHEET_CASPIAN);
        stageStandart = new StageStandart("main", false,
                stage, "kurs");
        this.stage = stageStandart.getStage();
        this.stage.setMinWidth(806.0);
        this.stage.setMinHeight(420.0);

    }
}