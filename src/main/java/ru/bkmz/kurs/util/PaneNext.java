package ru.bkmz.kurs.util;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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

                    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml/" + name + ".fxml")));

                    stage.setScene(new Scene(root));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}

class Notification {
     Notification(String name, String info) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(name);
        alert.setHeaderText(null);
        alert.setContentText(info);
        alert.showAndWait();
    }
}