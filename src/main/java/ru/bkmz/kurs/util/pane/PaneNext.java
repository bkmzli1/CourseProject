package ru.bkmz.kurs.util.pane;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import ru.bkmz.kurs.Main;

import java.util.Objects;

public class PaneNext {

    public PaneNext(AnchorPane rootPane, String name) {

        Platform.runLater(new Runnable() {

            @Override
            public void run() {
                try {

                    Stage stage = Main.stageStandart.getStage();

                    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource(name)));

                    stage.setScene(new Scene(root));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}

