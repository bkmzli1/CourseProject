package ru.bkmz.kurs.util.image;

import javafx.application.Platform;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.*;
import java.net.URL;


public class WrappedImageView extends ImageView {
    Thread off;
    Thread on;
    int time = 50;

    public WrappedImageView(Image image, String url) {
        super(image);


        setOnMouseEntered(event -> {
            try {

                off.join();

            } catch (Exception e) {
            }
            on = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (double i = 0d; i < 1d; i += 0.2d) {
                        double finalI = i;
                        try {
                            Thread.sleep(time);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                setEffect(new Glow(finalI));
                            }
                        });
                    }
                }
            });
            on.start();
        });
        setOnMouseExited(event -> {
            try {
                on.join();

            } catch (Exception e) {
            }
            off = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (double i = 1d; i > 0d; i -= 0.2d) {
                        try {
                            Thread.sleep(time);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        double finalI = i;
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                setEffect(new Glow(finalI));
                            }
                        });

                    }
                }
            });
            off.start();
        });
        setOnMouseClicked(event -> {
            openWebpage(url);
        });
        setPreserveRatio(true);

    }


    @Override
    public double minWidth(double height) {
        return 40;
    }

    @Override
    public double prefWidth(double height) {
        Image I = getImage();
        if (I == null) return minWidth(height);
        return I.getWidth();
    }

    @Override
    public double maxWidth(double height) {
        return 16384;
    }

    @Override
    public double minHeight(double width) {
        return 40;
    }

    @Override
    public double prefHeight(double width) {
        Image I = getImage();
        if (I == null) return minHeight(width);
        return I.getHeight();
    }

    @Override
    public double maxHeight(double width) {
        return 16384;
    }

    @Override
    public boolean isResizable() {
        return true;
    }

    @Override
    public void resize(double width, double height) {

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