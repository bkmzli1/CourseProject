package ru.bkmz.kurs.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ru.bkmz.kurs.Main;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class StageDialog {
    StageDialog() {
        StackPane secondaryLayout = new StackPane();

        Stage newWindow = new Stage();
        Scene secondScene = new Scene(secondaryLayout, 230, 100);
        newWindow.setScene(secondScene);
        newWindow.initModality(Modality.APPLICATION_MODAL);
        // Specifies the modality for new window.

        // Specifies the owner Window (parent) for new window
        newWindow.initOwner(Main.stageStandart.getStage());
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml/info.fxml")));
        // Set position of second window, related to primary window.
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        InputStream inputStream = ClassLoader.class.getResourceAsStream("/img/fon1.png");
        Image image = new Image(inputStream);
        newWindow.getIcons().add(image);
        newWindow.setScene(new Scene(root));
        newWindow.setResizable(false);
        newWindow.show();

    }
}
