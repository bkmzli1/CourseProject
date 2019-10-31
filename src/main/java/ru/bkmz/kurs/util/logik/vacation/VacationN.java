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


public class VacationN {

    public VacationN(VBox vBox, HBox hBoxButtons, Button score) {
        TextArea inf = textAreaBuild("" +
                "Снрп - Сумма начислений за расчётный период\n" +
                "Ккд - количество колендарных дней\n" +
                "Ккдо - количество колендарных дней отпусков\n" +
                "ккд-Количество календарных дней");

        VBox vBoxCDZ = new VBox(10);
        HBox hBox1 = new HBox(10);
        HBox hBox2 = new HBox(10);
        Text t0 = textBuild("сумма отпускных =");
        TextField snrp = textFieldBuild("", "Снрп");
        Text t1 = textBuild("/");
        TextField kkd = textFieldBuild("", "Ккд");
        Text t2 = textBuild("*");
        TextField kkdo = textFieldBuild("", "Ккдо");
        Text t3 = textBuild("- 29,4 *");
        TextField kpomrp = textFieldBuild("", "Ккдо");
        Text t4_2 = textBuild("+");
        Text t4 = textBuild("+ ( 29,4 /");

        TextField kkdnm1 = textFieldBuild("", "ккднм");
        Text t5 = textBuild("*");
        TextField kkdnvgov1 = textFieldBuild("", "ккднмпов");
        Text t6 = textBuild("+ 29,4 /");
        TextField kkdnm2 = textFieldBuild("", "ккднм");
        Text t7 = textBuild("*");
        TextField kkdnvgov2 = textFieldBuild("", "ккднмпов");
        Text t8 = textBuild(") ");
        Text out = textBuild("= ?");
        hBox1.getChildren().addAll(t0, snrp, t1, kkd, t2, kkdo, t3, kpomrp, t4_2);
        hBox2.getChildren().addAll(t4, kkdnm1, t5, kkdnvgov1, t6, kkdnm2, t7, kkdnvgov2, t8, out);
        vBoxCDZ.getChildren().addAll(hBox1, hBox2);
        vBox.getChildren().addAll(vBoxCDZ, inf);
        VBox.setVgrow(hBox1, Priority.ALWAYS);


        score.setOnMouseClicked(event -> {
            try {
                double snrpD = Double.parseDouble(snrp.getText()),
                        kkdD = Double.parseDouble(kkd.getText()),
                        kkdoD = Double.parseDouble(kkdo.getText()),
                        kpomrpD = Double.parseDouble(kpomrp.getText()),
                        kkdnm1D = Double.parseDouble(kkdnm1.getText()),
                        kkdnvgov1D = Double.parseDouble(kkdnvgov1.getText()),
                        kkdnm2D = Double.parseDouble(kkdnm2.getText()),
                        kkdnvgov2D = Double.parseDouble(kkdnvgov2.getText());


                out.setText("="+(snrpD/kkdD*kkdoD-24.4*kpomrpD+(29.4/kkdnm1D*kkdnvgov1D+29.4/kkdnm2D*kkdnvgov2D)));
            } catch (Exception e) {
                new Notification("уведомление", "Заполните все поля");
            }

        });
    }
}
