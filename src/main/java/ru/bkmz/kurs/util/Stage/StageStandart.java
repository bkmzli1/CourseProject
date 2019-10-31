package ru.bkmz.kurs.util.Stage;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;


public class StageStandart extends Stage {
    boolean follScren;
    Stage stage;
    public static FXMLLoader loader2 = new FXMLLoader();

    public StageStandart(String name, boolean follScren, Stage stage, String nameStage) {
        loader2.setLocation(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml/" + "info" + ".fxml")));
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml/" + name + ".fxml")));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }


        stage.setMaximized(follScren);


        Parent root = loader.getRoot();
        Scene scene = new Scene(root);

        scene.getStylesheets().add(Objects.requireNonNull(getClass().getClassLoader().getResource("css/main.css")).toExternalForm());
        stage.setScene(scene);
        stage.setTitle(nameStage);
        InputStream inputStream = ClassLoader.class.getResourceAsStream("/image/fon icon.png");
        try {
            Image image = new Image(inputStream);
            stage.getIcons().add(image);
        } catch (NullPointerException e) {
            System.out.println("icon null");
        }

        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                System.exit(0);
            }
        });
        try {

        } catch (Exception e) {
        }
        stage.show();
        this.stage = stage;
        //this.follScren = stage.isMaximized();
        //stage.setResizable(false);


    }

    public boolean isFollScren() {
        return follScren;
    }

    public Stage getStage() {
        return stage;
    }
}
