package ru.bkmz.kurs.controller;

import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import ru.bkmz.kurs.util.WrappedImageView;
import java.io.InputStream;

public class InfoController {
    public VBox vBoxAether;
    public VBox vBoxGit;

    private InputStream inputStreamAether = ClassLoader.class.getResourceAsStream("/image/fon1.png");
    private InputStream inputStreamGit = ClassLoader.class.getResourceAsStream("/image/github_PNG20.png");
    Image imageAether  = new Image(inputStreamAether);
    Image imageGit = new Image(inputStreamGit);

    public void initialize() {
        WrappedImageView imageAetherV = new WrappedImageView(imageAether);

        vBoxAether.getChildren().set(0, imageAetherV);
        WrappedImageView imageGitV = new WrappedImageView(imageGit);

        vBoxGit.getChildren().set(0, imageGitV);
        imageAetherV.setPreserveRatio(true);
        imageGitV.setPreserveRatio(true);

    }

    public void aether(ActionEvent actionEvent) {
        System.out.println(1);
    }

    public void git(ActionEvent actionEvent) {
        System.out.println(2);
    }
}
