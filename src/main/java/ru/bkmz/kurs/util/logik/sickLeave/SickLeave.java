package ru.bkmz.kurs.util.logik.sickLeave;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import ru.bkmz.kurs.util.Plant.Notification;

import static ru.bkmz.kurs.util.bulderElements.BuilderElements.*;

public class SickLeave {
    public SickLeave(VBox vBox, HBox HBoxButtons, Button score) {
        TextArea inf = textAreaBuild("");

        Text text2 = textBuild("свбл=");
        TextField sdz = textFieldBuild("", "СДЗ");
        Text text3 = textBuild("*");
        TextField proc = textFieldBuild("", "% от стажа");
        Text text4 = textBuild("*");
        TextField kdb = textFieldBuild("", "кдб");
        Text out = textBuild("= ?");
        HBox hBox = hBoxBulder();
        VBox.setVgrow(hBox, Priority.ALWAYS);
        hBox.getChildren().addAll(text2, sdz, text3, proc, text4, kdb, out);
        vBox.getChildren().addAll(hBox,inf);
        score.setOnMouseClicked(event -> {
            try{
            double
                    sdzD = Double.parseDouble(sdz .getText().replace(",", ".")),
                    procD= Double.parseDouble(proc.getText().replace(",", ".")),
                    kdbD = Double.parseDouble(kdb .getText().replace(",", "."));
            out.setText("= "+(sdzD*procD*kdbD));
            } catch (Exception e) {
                new Notification("уведомление", "Заполните все поля");
            }
        });
    }
}
