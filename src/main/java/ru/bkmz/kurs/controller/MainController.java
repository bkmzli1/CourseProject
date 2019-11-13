package ru.bkmz.kurs.controller;

import javafx.beans.value.ChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import ru.bkmz.kurs.Main;
import ru.bkmz.kurs.util.logics.holiday.holiday.Holiday;
import ru.bkmz.kurs.util.logics.holiday.sum.completely.Сompletely;
import ru.bkmz.kurs.util.logics.holiday.sum.incompletely.InCompletely;
import ru.bkmz.kurs.util.logics.leave.Leave;
import ru.bkmz.kurs.util.logics.seniority.Seniority;
import ru.bkmz.kurs.util.pane.Planet;
import ru.bkmz.kurs.util.pane.PlanetDAO;
import ru.bkmz.kurs.util.stage.StageDialog;

public class MainController {
    public ComboBox<Planet> functionSheet;

    public VBox vBox;
    public Button score;
    public Label out;
    public VBox rootVBox;


    public void initialize() {
        ChangeListener<Planet> changeListener = (observable, oldValue, newValue) -> {
            vBox.getChildren().clear();
            out.setText("Ответ:");
            switch (newValue.getCode()) {
                case "ртс":
                    new Seniority(vBox, score, out);
                    break;
                case "рсp":
                    new Сompletely(vBox, score, out);
                    try {
                        rootVBox.getChildren().addAll(out, score);
                    } catch (IllegalArgumentException ignored) {
                    }
                    ;

                    break;
                case "рсnp":
                    new InCompletely(vBox, score, out);
                    try {
                        rootVBox.getChildren().addAll(out, score);
                    } catch (IllegalArgumentException ignored) {
                    }
                    ;
                    break;
                case "рбл":
                    new Leave(vBox, score, out);
                    try {
                        rootVBox.getChildren().addAll(out, score);
                    } catch (IllegalArgumentException ignored) {
                    }
                    ;
                    break;
                case "ро":
                    new Holiday(vBox, score, out);
                    try {
                        rootVBox.getChildren().addAll(out, score);
                    } catch (IllegalArgumentException ignored) {
                    }
                    ;
                    break;
            }
        };

        ObservableList<Planet> planetObservableList = comboBoxLoader();

        functionSheet.setItems(planetObservableList);


        functionSheet.getSelectionModel().selectedItemProperty().addListener(changeListener);
        functionSheet.setValue(planetObservableList.get(0));


    }


    private ObservableList<Planet> comboBoxLoader() {
        PlanetDAO.load("ртс", "Расчет трудового стажа");
        PlanetDAO.load("рсp", "Расчет суммы отпускных (если расчетный период отработан полностью)");
        PlanetDAO.load("рсnp", "Расчет суммы отпускных (если расчетный период отработан не полностью)");
        PlanetDAO.load("рбл", "Расчет больничного листа");
        PlanetDAO.load("ро", "Расчет отпускных");


        return PlanetDAO.getPlanetList();
    }


    public void size(ActionEvent actionEvent) {
        System.out.println("w:" + Main.stage.getWidth());
        System.out.println("h:" + Main.stage.getHeight());

    }

    public void close(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void about(ActionEvent actionEvent) {
        StageDialog stageDialog = new StageDialog();
    }
}
