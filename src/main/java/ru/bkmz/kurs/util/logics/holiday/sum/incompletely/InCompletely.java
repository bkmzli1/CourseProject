package ru.bkmz.kurs.util.logics.holiday.sum.incompletely;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.text.DecimalFormat;

import static ru.bkmz.kurs.build.BuilderElements.textFieldBuild;

public class InCompletely {
    public InCompletely(VBox vBox, Button score, Label out) {
        TextField snrp = textFieldBuild("", "Сумма начислений за расчётный период","срок деятельности юридического лица, исчисляемый в календарных месяцах");
        TextField kkd = textFieldBuild("", "Количество колендарных дней");
        TextField kkdo = textFieldBuild("", "Количество колендарных дней отпусков","Согласно с законодательством РФ срок основного ежегодного отпуска составляет 28 календарных дня с учетом выходных");
        TextField kkdnvgov = textFieldBuild("", "Количество полностью отработанных месяцев в расчетном периоде");
        TextField kkdnmpov = textFieldBuild("", "Количество календарных дней в неполном месяце,приходящихся на отработанное время");
        TextField kkdnm = textFieldBuild("", "Количество календарных дней в неполном месяце","рассчитывается путем деления среднемесячного числа календарных дней (29,3) на количество календарных дней этого месяца и умножения на количество календарных дней,\n приходящихся на время, отработанное в данном месяце.");
        score.setOnMouseClicked(event -> {
            double snrpD = Double.parseDouble(snrp.getText()),
                    kkdD = Double.parseDouble(kkd.getText()),
                    kkdoD = Double.parseDouble(kkdo.getText()),
                    kkdnvgovD = Double.parseDouble(kkdnvgov.getText()),
                    kkdnmpovD = Double.parseDouble(kkdnmpov.getText()),
                    kkdnmD = Double.parseDouble(kkdnm.getText());

            out.setText("Ответ: " + (snrpD / kkdD * kkdoD - 24.4f * kkdnvgovD + (29.4f / kkdnmD * kkdnmpovD + 29.4f / kkdnmD * kkdnmpovD)));
        });
        tF(snrp, kkd, kkdo, kkdnvgov, kkdnmpov, kkdnm, out);
        vBox.getChildren().addAll(snrp, kkd, kkdo, kkdnvgov, kkdnmpov,kkdnm);

    }

    void tF(TextField snrp, TextField kkd, TextField kkdo, TextField kkdnvgov, TextField kkdnmpov, TextField kkdnm, Label out) {

        snrp.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                try {

                    double snrpD = Double.parseDouble(snrp.getText()),
                            kkdD = Double.parseDouble(kkd.getText()),
                            kkdoD = Double.parseDouble(kkdo.getText()),
                            kkdnvgovD = Double.parseDouble(kkdnvgov.getText()),
                            kkdnmpovD = Double.parseDouble(kkdnmpov.getText()),
                            kkdnmD = Double.parseDouble(kkdnm.getText());


                    out.setText("Ответ: " + (snrpD / kkdD * kkdoD - 24.4f * kkdnvgovD + (29.4f / kkdnmD * kkdnmpovD + 29.4f / kkdnmD * kkdnmpovD)));
                } catch (Exception e) {
                }
            }
        });
        kkd.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                try {
                    double snrpD = Double.parseDouble(snrp.getText()),
                            kkdD = Double.parseDouble(kkd.getText()),
                            kkdoD = Double.parseDouble(kkdo.getText()),
                            kkdnvgovD = Double.parseDouble(kkdnvgov.getText()),
                            kkdnmpovD = Double.parseDouble(kkdnmpov.getText()),
                            kkdnmD = Double.parseDouble(kkdnm.getText());

                    out.setText("Ответ: " + (snrpD / kkdD * kkdoD - 24.4f * kkdnvgovD + (29.4f / kkdnmD * kkdnmpovD + 29.4f / kkdnmD * kkdnmpovD)));
                } catch (Exception e) {
                }
            }
        });
        kkdo.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                try {
                    double snrpD = Double.parseDouble(snrp.getText()),
                            kkdD = Double.parseDouble(kkd.getText()),
                            kkdoD = Double.parseDouble(kkdo.getText()),
                            kkdnvgovD = Double.parseDouble(kkdnvgov.getText()),
                            kkdnmpovD = Double.parseDouble(kkdnmpov.getText()),
                            kkdnmD = Double.parseDouble(kkdnm.getText());

                    out.setText("Ответ: " + (snrpD / kkdD * kkdoD - 24.4f * kkdnvgovD + (29.4f / kkdnmD * kkdnmpovD + 29.4f / kkdnmD * kkdnmpovD)));
                } catch (Exception e) {
                }
            }
        });
        kkdnvgov.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                try {
                    double snrpD = Double.parseDouble(snrp.getText()),
                            kkdD = Double.parseDouble(kkd.getText()),
                            kkdoD = Double.parseDouble(kkdo.getText()),
                            kkdnvgovD = Double.parseDouble(kkdnvgov.getText()),
                            kkdnmpovD = Double.parseDouble(kkdnmpov.getText()),
                            kkdnmD = Double.parseDouble(kkdnm.getText());

                    out.setText("Ответ: " + (snrpD / kkdD * kkdoD - 24.4f * kkdnvgovD + (29.4f / kkdnmD * kkdnmpovD + 29.4f / kkdnmD * kkdnmpovD)));
                } catch (Exception e) {
                }
            }
        });
        kkdnmpov.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                try {
                    double snrpD = Double.parseDouble(snrp.getText()),
                            kkdD = Double.parseDouble(kkd.getText()),
                            kkdoD = Double.parseDouble(kkdo.getText()),
                            kkdnvgovD = Double.parseDouble(kkdnvgov.getText()),
                            kkdnmpovD = Double.parseDouble(kkdnmpov.getText()),
                            kkdnmD = Double.parseDouble(kkdnm.getText());

                    out.setText("Ответ: " + (snrpD / kkdD * kkdoD - 24.4f * kkdnvgovD + (29.4f / kkdnmD * kkdnmpovD + 29.4f / kkdnmD * kkdnmpovD)));
                } catch (Exception e) {
                }
            }
        });
        kkdnm.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                try {
                    double snrpD = Double.parseDouble(snrp.getText()),
                            kkdD = Double.parseDouble(kkd.getText()),
                            kkdoD = Double.parseDouble(kkdo.getText()),
                            kkdnvgovD = Double.parseDouble(kkdnvgov.getText()),
                            kkdnmpovD = Double.parseDouble(kkdnmpov.getText()),
                            kkdnmD = Double.parseDouble(kkdnm.getText());

                    out.setText("Ответ: " + (snrpD / kkdD * kkdoD - 24.4f * kkdnvgovD + (29.4f / kkdnmD * kkdnmpovD + 29.4f / kkdnmD * kkdnmpovD)));
                } catch (Exception e) {
                }
            }
        });
    }
}
