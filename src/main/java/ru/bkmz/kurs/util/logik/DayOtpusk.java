package ru.bkmz.kurs.util.logik;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import ru.bkmz.kurs.util.Plant.Notification;

import java.text.DecimalFormat;

import static ru.bkmz.kurs.util.bulderElements.BuilderElements.*;

public class DayOtpusk {
    public DayOtpusk(VBox vBox, HBox HBoxButtons, Button score) {


        Text t0 = textBuild("Количество дней отпуска = 28д / 12мес. *");

        TextField mes = textFieldBuild("", "Ком");
        Text out = textBuild("= ?");
        HBox hBox = hBoxBulder();
        hBox.getChildren().addAll(t0, mes, out);
        vBox.getChildren().addAll(hBox);

        DecimalFormat df = new DecimalFormat("0.###");
        score.setOnMouseClicked(event -> {
            try {
                double dMes = Double.parseDouble(mes.getText());
                out.setText("= " + df.format((28f / 12f * dMes)));
            } catch (Exception e) {
                new Notification("уведомление", "Заполните все поля");
            }

        });
        infBilder(vBox, "Ком - количество отработаных месяцев");
    }
}
