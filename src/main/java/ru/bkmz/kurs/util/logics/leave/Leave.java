package ru.bkmz.kurs.util.logics.leave;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import ru.bkmz.kurs.util.pane.Notification;

import java.text.DecimalFormat;

import static ru.bkmz.kurs.build.BuilderElements.textFieldBuild;

public class Leave {

    public Leave(VBox vBox, Button score, Label out) {
        TextField sdz = textFieldBuild("", "Средний дневной заработок сотрудника за определённый период");
        TextField proc = textFieldBuild("", "% от стажа");
        TextField kdb = textFieldBuild("", "Количество дней по больничному листу");
        score.setOnMouseClicked(event -> {
            try {
                double
                        sdzD = Double.parseDouble(sdz.getText().replace(",", ".")),
                        procD = Double.parseDouble(proc.getText().replace(",", ".")),
                        kdbD = Double.parseDouble(kdb.getText().replace(",", "."));
                out.setText("Ответ: "  + (sdzD * procD * kdbD));
            } catch (Exception e) {
                new Notification("уведомление", "Заполните все поля");
            }
        });
        tF(sdz, proc, kdb, out);
        vBox.getChildren().addAll(sdz, proc, kdb);

    }

    void tF(TextField sdz, TextField proc, TextField kdb, Label out) {

        sdz.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                try {
                    double
                            sdzD = Double.parseDouble(sdz.getText().replace(",", ".")),
                            procD = Double.parseDouble(proc.getText().replace(",", ".")),
                            kdbD = Double.parseDouble(kdb.getText().replace(",", "."));
                    out.setText("Ответ: "  + (sdzD * procD * kdbD));
                } catch (Exception e) {
                }
            }
        });
        proc.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                try {
                    double
                            sdzD = Double.parseDouble(sdz.getText().replace(",", ".")),
                            procD = Double.parseDouble(proc.getText().replace(",", ".")),
                            kdbD = Double.parseDouble(kdb.getText().replace(",", "."));
                    out.setText("Ответ: "  + (sdzD * procD * kdbD));
                } catch (Exception e) {
                }
            }
        });
        kdb.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                try {
                    double
                            sdzD = Double.parseDouble(sdz.getText().replace(",", ".")),
                            procD = Double.parseDouble(proc.getText().replace(",", ".")),
                            kdbD = Double.parseDouble(kdb.getText().replace(",", "."));
                    out.setText("Ответ: "  + (sdzD * procD * kdbD));
                } catch (Exception e) {
                }
            }
        });

    }
}
