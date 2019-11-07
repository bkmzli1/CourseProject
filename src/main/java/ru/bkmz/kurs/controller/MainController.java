package ru.bkmz.kurs.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import ru.bkmz.kurs.Main;
import ru.bkmz.kurs.util.Plant.Planet;
import ru.bkmz.kurs.util.Plant.PlanetDAO;
import ru.bkmz.kurs.util.Stage.StageDialog;
import ru.bkmz.kurs.util.logik.DayOtpusk;
import ru.bkmz.kurs.util.logik.seniority.Seniority;
import ru.bkmz.kurs.util.logik.sickLeave.SickLeave;
import ru.bkmz.kurs.util.logik.vacation.Vacation;
import ru.bkmz.kurs.util.logik.vacation.VacationN;


public class MainController {
    public ComboBox<Planet> functionSheet;
    public Button score;
    public VBox vBox;
    static StageDialog stageDialog;
    public HBox HBoxButtons;

    public void initialize() {
        ChangeListener<Planet> changeListener = new ChangeListener<Planet>() {
            @Override
            public void changed(ObservableValue<? extends Planet> observable, Planet oldValue, Planet newValue) {
                vBox.getChildren().clear();
                HBoxButtons.getChildren().clear();
                HBoxButtons.getChildren().add(score);
                switch (newValue.getCode()) {
                    case "ртс":
                        new Seniority(vBox, HBoxButtons, score);
                        break;
                    case "рсp":
                        new Vacation(vBox, HBoxButtons, score);
                        break;
                    case "рсnp":
                        new VacationN(vBox, HBoxButtons, score);
                        break;
                    case "рбл":
                        new SickLeave(vBox, HBoxButtons, score);
                        break;
                    case "ро":
                        new DayOtpusk(vBox, HBoxButtons, score);
                        break;
                }
            }
        };

        ObservableList<Planet> planetObservableList = comboBoxLoader();

        functionSheet.setItems(planetObservableList);


        functionSheet.getSelectionModel().selectedItemProperty().addListener(changeListener);
        functionSheet.setValue(planetObservableList.get(0));


    }


    public ObservableList<Planet> comboBoxLoader() {
        PlanetDAO.load("ртс", "Расчет трудового стажа");
        PlanetDAO.load("рсp", "Расчет суммы отпускных (если расчетный периуд отработан полнастью)");
        PlanetDAO.load("рсnp", "Расчет суммы отпускных (если расчетный периуд отработан не полнастью)");
        PlanetDAO.load("рбл", "Расчет больничного листа");
        PlanetDAO.load("ро", "Расчет отпускных");


        ObservableList<Planet> list = PlanetDAO.getPlanetList();
        return list;
    }


    public void size(ActionEvent actionEvent) {
        System.out.println("w:" + Main.stage.getWidth());
        System.out.println("h:" + Main.stage.getHeight());

    }

    public void close(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void about(ActionEvent actionEvent) {
        stageDialog = new StageDialog();
    }
}
