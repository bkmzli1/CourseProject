package ru.bkmz.kurs.util.logik.vacation;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import ru.bkmz.kurs.util.Plant.Notification;

import static ru.bkmz.kurs.util.bulderElements.BuilderElements.*;


public class Vacation {

    public Vacation(VBox vBox, HBox hBoxButtons, Button score) {
        TextArea inf = textAreaBuild("" +
                "Снрп - Сумма начислений за расчётный период\n" +
                "Ккд - количество колендарных дней отпусков");

        VBox vBoxCDZ = new VBox(10);
        HBox hBox = new HBox(10);
        Text t0 = textBuild("сумма отпускных =");
        TextField snrp = textFieldBuild("", "Снрп");
        Text t1 = textBuild("/ 12мес. / 29,4дн. *");
        TextField kkd = textFieldBuild("", "Ккд");
        Text out = textBuild("= ?");
        hBox.getChildren().addAll(t0,snrp, t1, kkd, out);
        vBoxCDZ.getChildren().addAll(hBox);
        vBox.getChildren().addAll(vBoxCDZ, inf);
        HBox.setHgrow(snrp, Priority.ALWAYS);
        VBox.setVgrow(hBox, Priority.ALWAYS);


        score.setOnMouseClicked(event -> {
            try {
                double dSnrp = Double.parseDouble(snrp.getText().replace(",","."));
                double dKkd = Double.parseDouble(kkd.getText().replace(",","."));
                out.setText("=" + (dSnrp / 12f / 29.4f * dKkd));
            }catch (Exception e){
                new Notification("уведомление", "Заполните все поля");
            }

        });
    }
}
