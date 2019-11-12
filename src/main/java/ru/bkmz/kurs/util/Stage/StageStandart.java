package ru.bkmz.kurs.util.Stage;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;


public class StageStandart extends Stage {
    private boolean follScren;
    private Stage stage;
    public StageStandart(String name, boolean follScren, Stage stage, String nameStage) {

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
        Dimension sSize = Toolkit.getDefaultToolkit ().getScreenSize ();

        stage.setHeight(sSize.height/2f);
        stage.setWidth(sSize.width/2f);
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
