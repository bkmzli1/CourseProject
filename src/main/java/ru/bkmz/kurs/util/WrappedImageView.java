package ru.bkmz.kurs.util;

import javafx.event.Event;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.*;
import java.net.URL;


public class WrappedImageView extends ImageView {
    public WrappedImageView(Image image)
    {

        super(image);
    }

    @Override
    public double minWidth(double height)
    {
        return 40;
    }

    @Override
    public double prefWidth(double height)
    {
        Image I=getImage();
        if (I==null) return minWidth(height);
        return I.getWidth();
    }

    @Override
    public double maxWidth(double height)
    {
        return 16384;
    }

    @Override
    public double minHeight(double width)
    {
        return 40;
    }

    @Override
    public double prefHeight(double width)
    {
        Image I=getImage();
        if (I==null) return minHeight(width);
        return I.getHeight();
    }

    @Override
    public double maxHeight(double width)
    {
        return 16384;
    }

    @Override
    public boolean isResizable()
    {
        return true;
    }

    @Override
    public void resize(double width, double height)
    {
        setOnMouseEntered(event -> {
           setEffect(new Glow(1));
        });
        setOnMouseExited(event -> {
            setEffect(new Glow(0));
        });
        setOnMouseClicked(event -> {
            openWebpage("https://github.com/bkmzli1");
        });
        setFitWidth(width);
        setFitHeight(height);
    }

    private static void openWebpage(String urlString) {
        try {
            Desktop.getDesktop().browse(new URL(urlString).toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}