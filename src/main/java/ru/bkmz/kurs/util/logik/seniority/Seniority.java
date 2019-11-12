package ru.bkmz.kurs.util.logik.seniority;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import ru.bkmz.kurs.util.Plant.Notification;

import java.util.ArrayList;

import static ru.bkmz.kurs.util.bulderElements.BuilderElements.*;


public class Seniority {
    private static TableView<SeniorityTable> table = new TableView<>();
    private static ArrayList<TableColumn<SeniorityTable, String>> tableColumns = new ArrayList<TableColumn<SeniorityTable, String>>();
    private static ObservableList<SeniorityTable> list = FXCollections.observableArrayList();
    private ArrayList<DatePicker> DatePickerD = new ArrayList<>();
    private ArrayList<DatePicker> DatePickerR = new ArrayList<>();

    public Seniority(VBox rootVBox, HBox hBoxButtons, Button score) {
        table = new TableView<>();
        tableColumns = new ArrayList<TableColumn<SeniorityTable, String>>();
        list = FXCollections.observableArrayList();
        DatePickerD = new ArrayList<>();
        DatePickerR = new ArrayList<>();
        list = FXCollections.observableArrayList();
        creaseCorundumMin("№ п/п", "id");
        creaseCorundumMax("Дата приема на работу", "dataReception");
        creaseCorundumMax("Дата увольнения", "dateDismissal");
        for (int i = 0; i < tableColumns.size(); i++) {
            table.getColumns().add(tableColumns.get(i));
        }

        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        table.setTableMenuButtonVisible(true);
        VBox.setVgrow(table, Priority.ALWAYS);


        rootVBox.getChildren().addAll(table);
        Button add = ButtonBuild("Добавить");

        add.setOnMouseClicked(event -> {
            listLoader();
        });
        Button remove = ButtonBuild("Удалить всё");
        remove.setOnMouseClicked(event -> {
            remove();
        });
        CheckBox checkBox = new CheckBox("Включая конечную дату".toUpperCase());
        checkBox.setId("text");
        checkBox.setMaxHeight(Double.MAX_VALUE);
        Label label = labelBuild("Трудовой стаж: " + "дд//мм//гггг");
        label.setId("text");
        HBox.setHgrow(label, Priority.ALWAYS);
        label.setMaxHeight(Double.MAX_VALUE);
        label.setMaxWidth(Double.MAX_VALUE);
        listLoader();

        score.setOnMouseClicked(event -> {
            try {


                int yD = 0, mD = 0, dD = 0;
                int yR = 0, mR = 0, dR = 0;
                int y = 0, m = 0, d = 0;

                for (DatePicker dp :
                        DatePickerD) {
                    String[] dateS = dp.getEditor().getText().split("/");
                    dD += Integer.parseInt(dateS[0]);
                    mD += Integer.parseInt(dateS[1]);
                    yD += Integer.parseInt(dateS[2]);

                }
                for (DatePicker dp :
                        DatePickerR) {
                    String[] dateS = dp.getEditor().getText().split("/");
                    dR += Integer.parseInt(dateS[0]);
                    mR += Integer.parseInt(dateS[1]);
                    yR += Integer.parseInt(dateS[2]);

                }
                if (checkBox.isSelected()) {
                    dD += 1;
                }
                y = yD - yR;
                m = mD - mR;
                d = dD - dR;

                label.setText("Трудовой стаж: ".toUpperCase() + Math.abs(d) + "/" + Math.abs(m) + "/" + Math.abs(y));
            } catch (NumberFormatException e) {
                new Notification("уведомление", "Заполните все поля");
            }
        });

        VBox vBox = vBoxBulder();
        HBox.setHgrow(vBox, Priority.ALWAYS);
        VBox.setVgrow(vBox, Priority.ALWAYS);
        vBox.getChildren().addAll(add, remove);
        hBoxButtons.getChildren().add(0, vBox);
        hBoxButtons.getChildren().add(0, checkBox);
        hBoxButtons.getChildren().add(0, label);
        //infBilder(rootVBox, "Ком - количество отработаных месяцев");
        add.setCancelButton(true);
    }


    void remove() {
        list.clear();
        table.setItems(list);
    }

    private void listLoader() {
        DatePicker datePickerD = new DatePicker();
        DatePicker datePickerR = new DatePicker();
        if ((String.valueOf(list.size() + 1).length()) == 1) {
            this.DatePickerD.add(datePickerD);
            this.DatePickerR.add(datePickerR);
            list.add(new SeniorityTable(" 00" + (list.size() + 1), datePickerR, datePickerD));

        } else if ((String.valueOf(list.size() + 1).length()) == 2) {
            this.DatePickerD.add(datePickerD);
            this.DatePickerR.add(datePickerR);
            list.add(new SeniorityTable(" 0" + (list.size() + 1), datePickerR, datePickerD));

        } else if ((String.valueOf(list.size() + 1).length()) == 3) {
            this.DatePickerD.add(datePickerD);
            this.DatePickerR.add(datePickerR);
            list.add(new SeniorityTable(" " + (list.size() + 1), datePickerR, datePickerD));

        }
        tableColumns.get(0).setMaxWidth(60);
        tableColumns.get(0).setMinWidth(60);
        table.setItems(list);
    }


    void creaseCorundumMin(String name, String value) {

        TableColumn<SeniorityTable, String> tableColumn = new TableColumn<SeniorityTable, String>(name);
        tableColumn.setCellValueFactory(new PropertyValueFactory<>(value));
        tableColumn.setMinWidth(Region.USE_COMPUTED_SIZE);
        tableColumn.setResizable(false);
        tableColumn.setSortable(false);
        tableColumns.add(tableColumn);

    }

    void creaseCorundumMax(String name, String value) {
        TableColumn<SeniorityTable, String> tableColumn = new TableColumn<SeniorityTable, String>(name);
        tableColumn.setCellValueFactory(new PropertyValueFactory<>(value));
        tableColumn.setMinWidth(100);
        tableColumn.setSortable(false);
        tableColumns.add(tableColumn);

    }


}
