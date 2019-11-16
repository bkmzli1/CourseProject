package ru.bkmz.kurs.util.logics.holiday.holiday;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import ru.bkmz.kurs.util.pane.Notification;

import java.text.DecimalFormat;

import static ru.bkmz.kurs.build.BuilderElements.textFieldBuild;

public class Holiday {
    public Holiday(VBox vBox, Button score, Label out) {
        TextField mes = textFieldBuild("", "Количество отработаных месяцев");

        score.setOnMouseClicked(event -> {
            try {
                double dMes = Double.parseDouble(mes.getText());
                out.setText("Ответ: "  + (28f / 12f * dMes));
            } catch (Exception e) {
                new Notification("уведомление", "Заполните все поля");
            }

        });
        tF(mes,out);
    vBox.getChildren().addAll(mes);
    }
    void tF(TextField mes, Label out){

        mes.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                try {
                    double dMes = Double.parseDouble(mes.getText());
                    out.setText("Ответ: "  + (28f / 12f * dMes));
                } catch (Exception e) {
                }
            }
        });
    }
}
