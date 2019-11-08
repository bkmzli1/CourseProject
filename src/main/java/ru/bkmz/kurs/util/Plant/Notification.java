package ru.bkmz.kurs.util.Plant;

import javafx.scene.control.Alert;

public class Notification {
     public Notification(String name, String info) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(name);
        alert.setHeaderText(null);
        alert.setContentText(info);
        alert.showAndWait();
    }
}
