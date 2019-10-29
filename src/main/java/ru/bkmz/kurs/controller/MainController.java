package ru.bkmz.kurs.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import ru.bkmz.kurs.util.logik.Functions;
import ru.bkmz.kurs.util.Plant.Planet;
import ru.bkmz.kurs.util.Plant.PlanetDAO;
import ru.bkmz.kurs.util.Stage.StageDialog;


public class MainController {
    public ComboBox<Planet> functionSheet;
    public Button score;
    public VBox vBox;
   static StageDialog stageDialog;

    public void initialize() {

        ChangeListener<Planet> changeListener = new ChangeListener<Planet>() {
            @Override
            public void changed(ObservableValue<? extends Planet> observable, Planet oldValue, Planet newValue) {
                new Functions(observable, vBox, score);

            }
        };

        ObservableList<Planet> planetObservableList = comboBoxLoader();

        functionSheet.setItems(planetObservableList);


        functionSheet.getSelectionModel().selectedItemProperty().addListener(changeListener);
        functionSheet.setValue(planetObservableList.get(0));


    }


    public ObservableList<Planet> comboBoxLoader() {
        PlanetDAO.load("Кт", "Коэффициент текучести кадров");
        PlanetDAO.load("Кст", "Коэффициент стабильности кадров");
        PlanetDAO.load("Кд", "Коэффициент динамики числа занятых сотрудников");
        PlanetDAO.load("Кпк", "Коэффициент приема кадров");
        PlanetDAO.load("Квк", "Коэффициент выбытия кадров");
        PlanetDAO.load("ргппк", "Расчета годового процента по кредиту");
        PlanetDAO.load("пск", "Полная стоимость кредита");
        PlanetDAO.load("ркап", "Расчета кредита аннуитетными платежами");


      //  PlanetDAO.load("all", "Решение примеров");


        ObservableList<Planet> list = PlanetDAO.getPlanetList();
        return list;
    }


    public void size(ActionEvent actionEvent) {

    }

    public void close(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void about(ActionEvent actionEvent) {
        stageDialog = new StageDialog();
    }
}
