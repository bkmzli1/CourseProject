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
    Stage newWindow = new Stage();
    public StageDialog() {
        StackPane secondaryLayout = new StackPane();


        Scene secondScene = new Scene(secondaryLayout, 598, 317);
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
        InputStream inputStream = ClassLoader.class.getResourceAsStream("/image/fon icon.png");
        try {
            Image image = new Image(inputStream);
            newWindow.getIcons().add(image);
        } catch (NullPointerException e) {
            System.out.println("icon null");
        }

        Scene scene =new Scene(root);
        scene.getStylesheets().add(getClass().getClassLoader().getResource("css\\main.css").toExternalForm());
        newWindow.setScene(scene);
        newWindow.setWidth(598);
        newWindow.setHeight(360);
        newWindow.setResizable(false);

        newWindow.show();


    }

    public Stage getNewWindow() {
        return newWindow;
    }

    public void setNewWindow(Stage newWindow) {
        this.newWindow = newWindow;
    }
}
