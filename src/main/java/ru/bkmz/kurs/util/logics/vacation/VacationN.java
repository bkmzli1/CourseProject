package ru.bkmz.kurs.util.logics.vacation;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import ru.bkmz.kurs.util.pane.Notification;

import java.text.DecimalFormat;

import static ru.bkmz.kurs.util.build.BuilderElements.*;


public class VacationN {

    public VacationN(VBox vBox, HBox hBoxButtons, Button score) {

        VBox vBoxCDZ = vBoxBulder();
        HBox hBox1 = hBoxBulder();
        HBox hBox2 = hBoxBulder();
        Text t0 = textBuild("Сумма отпускных =");
        TextField snrp = textFieldBuild("", "Снрп");
        Text t1 = textBuild("/");
        TextField kkd = textFieldBuild("", "Ккд");
        Text t2 = textBuild("*");
        TextField kkdo = textFieldBuild("", "Ккдо");
        Text t3 = textBuild("- 29,4 *");
        TextField kpomrp = textFieldBuild("", "Ккдо");
        Text t4_2 = textBuild("+");
        Text t4 = textBuild("+ ( 29,4 /");

        TextField kkdnm1 = textFieldBuild("", "Ккднм");
        Text t5 = textBuild("*");
        TextField kkdnvgov1 = textFieldBuild("", "Ккднмпов");
        Text t6 = textBuild("+ 29,4 /");
        TextField kkdnm2 = textFieldBuild("", "Ккднм");
        Text t7 = textBuild("*");
        TextField kkdnvgov2 = textFieldBuild("", "Ккднмпов");
        Text t8 = textBuild(") ");
        Text out = textBuild("= ?");
        hBox1.getChildren().addAll(t0, snrp, t1, kkd, t2, kkdo, t3, kpomrp, t4_2);
        hBox2.getChildren().addAll(t4, kkdnm1, t5, kkdnvgov1, t6, kkdnm2, t7, kkdnvgov2, t8, out);
        vBoxCDZ.getChildren().addAll(hBox1, hBox2);
        vBox.getChildren().addAll(vBoxCDZ);
        VBox.setVgrow(hBox1, Priority.ALWAYS);
        DecimalFormat df = new DecimalFormat("0.###");

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


                out.setText("= " + df.format((snrpD / kkdD * kkdoD - 24.4f * kpomrpD + (29.4f / kkdnm1D * kkdnvgov1D + 29.4f / kkdnm2D * kkdnvgov2D))));
            } catch (Exception e) {
                new Notification("уведомление", "Заполните все поля");
            }

        });
        infBilder(vBox, "" +
                "Снрп - Сумма начислений за расчётный период\n" +
                "Ккд - количество колендарных дней\n" +
                "Ккдо - количество колендарных дней отпусков\n" +
                "Ккд-Количество календарных дней");
    }
}
