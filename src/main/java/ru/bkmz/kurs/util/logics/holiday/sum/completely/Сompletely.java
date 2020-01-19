package ru.bkmz.kurs.util.logics.holiday.sum.completely;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import ru.bkmz.kurs.util.pane.Notification;

import java.text.DecimalFormat;

import static ru.bkmz.kurs.build.BuilderElements.*;


public class Сompletely {
    public Сompletely(VBox vBox, Button score, Label out) {
        TextField snrp = textFieldBuild("", "Сумма начислений за расчётный период"," Срок деятельности юридического лица, исчисляемый в календарных месяцах");
        TextField kkd = textFieldBuild("", "Количество колендарных дней отпусков","Согласно с законодательством РФ срок основного ежегодного отпуска составляет 28 календарных дня с учетом выходных");

        Button button = buttonBuild("");
        score.setOnMouseClicked(event -> {
            try {
                double dSnrp = Double.parseDouble(snrp.getText().replace(",", "."));
                double dKkd = Double.parseDouble(kkd.getText().replace(",", "."));
                out.setText("Ответ: " + (dSnrp / 12f / 29.4f * dKkd));
            } catch (Exception e) {
                new Notification("уведомление", "Заполните все поля");
            }

        });
        tF(kkd, snrp, snrp, out);
        tF(kkd,snrp,kkd,out);
        vBox.getChildren().addAll(snrp, kkd);

    }
    void tF(TextField kkd, TextField snrp, TextField textField, Label out){

        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                try {
                    double dSnrp = Double.parseDouble(snrp.getText().replace(",", "."));
                    double dKkd = Double.parseDouble(kkd.getText().replace(",", "."));
                    out.setText("Ответ: " + (dSnrp / 12f / 29.4f * dKkd));
                } catch (Exception e) {
                }
            }
        });
    }
}
