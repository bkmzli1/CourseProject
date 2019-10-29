package ru.bkmz.kurs.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;

import ru.bkmz.kurs.util.image.WrappedImageView;

import java.io.InputStream;

public class InfoController {
    public VBox vBoxAether;
    public VBox vBoxGit;
    public VBox vBoxVK;
    public VBox vBoxGoogle;
    public Label title;

    private InputStream inputStreamAether = ClassLoader.class.getResourceAsStream("/image/fon1.png");
    private InputStream inputStreamGit = ClassLoader.class.getResourceAsStream("/image/github_PNG20.png");
    private InputStream inputStreamVK = ClassLoader.class.getResourceAsStream("/image/vk.png");
    private InputStream inputStreamGoogle = ClassLoader.class.getResourceAsStream("/image/gmail.png");

    Image imageAether = new Image(inputStreamAether);
    Image imageGit = new Image(inputStreamGit);
    Image imageVk = new Image(inputStreamVK);
    Image imageGoogle = new Image(inputStreamGoogle);


    public void initialize() {
        title.setId("title");
        imageBuilder(imageGit, "https://github.com/bkmzli1", vBoxGit);
        imageBuilder(imageAether, "https://github.com/bkmzli1", vBoxAether);
        imageBuilder(imageVk, "https://vk.com/id409602224", vBoxVK);
        imageBuilder(imageGoogle, "https://myaccount.google.com/?utm_source=OGB&tab=mk&utm_medium=act", vBoxGoogle);


    }


    private void imageBuilder(Image image, String url, VBox vBox) {
        WrappedImageView imageV = null;

        imageV = new WrappedImageView(image, url);

        vBox.getChildren().set(0, imageV);
    }

    public void aether(ActionEvent actionEvent) {
        System.out.println(1);
    }

    public void git(ActionEvent actionEvent) {
        System.out.println(2);
    }

    @FXML
    protected void loginButtonAction(ActionEvent actionEvent) {

    }
}
