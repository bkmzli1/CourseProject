package ru.bkmz.kurs.util.logics.seniority;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import ru.bkmz.kurs.util.pane.Notification;

import java.util.ArrayList;

import static ru.bkmz.kurs.build.BuilderElements.*;


public class Seniority {


    private static TableView<SeniorityTable> table;
    private static ArrayList<TableColumn<SeniorityTable, String>> tableColumns;
    private static ObservableList<SeniorityTable> list = FXCollections.observableArrayList();
    private ArrayList<DatePicker> DatePickerD;
    private ArrayList<DatePicker> DatePickerR;

    public Seniority(VBox vBox, Button score, Label out) {

        table = new TableView<>();
        tableColumns = new ArrayList<>();
        list = FXCollections.observableArrayList();
        DatePickerD = new ArrayList<>();
        DatePickerR = new ArrayList<>();
        creaseCorundumMin("№ п/п", "id");
        creaseCorundumMax("Дата приема на работу", "dataReception");
        creaseCorundumMax("Дата увольнения", "dateDismissal");
        for (TableColumn<SeniorityTable, String> tableColumn : tableColumns) {
            table.getColumns().add(tableColumn);
        }


        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        table.setTableMenuButtonVisible(true);
        VBox.setVgrow(table, Priority.ALWAYS);


        vBox.getChildren().addAll(table);
        Button add = buttonBuild("Добавить");

        add.setOnMouseClicked(event -> {
            listLoader();
        });
        Button remove = buttonBuild("Удалить всё");
        remove.setOnMouseClicked(event -> {
            remove();
        });
        CheckBox checkBox = new CheckBox("Включая конечную дату".toUpperCase());
        checkBox.setId("text");
        checkBox.setMaxHeight(Double.MAX_VALUE);
        listLoader();
        score.setOnMouseClicked(event -> {
            try {


                int yD = 0, mD = 0, dD = 0;
                int yR = 0, mR = 0, dR = 0;
                int y, m, d;

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

                y = yD - yR;
                m = mD - mR;
                d = dD - dR;


                if (checkBox.isSelected()) {
                    out.setText("Ответ: Дней " + Math.abs(d+1) + ", Месецев " + Math.abs(m) + ", Лет " + Math.abs(y));
                }else {
                    out.setText("Ответ: Дней " + Math.abs(d) + ", Месецев " + Math.abs(m) + ", Лет " + Math.abs(y));
                }
            } catch (NumberFormatException e) {
                new Notification("уведомление", "Заполните все поля");
            }
        });

        HBox.setHgrow(vBox, Priority.ALWAYS);
        VBox.setVgrow(vBox, Priority.ALWAYS);

        vBox.getChildren().addAll(out,checkBox, add, remove, score);
        add.setCancelButton(true);


    }


    private void remove() {
        DatePickerD.clear();
        DatePickerR.clear();
        list.clear();
        listLoader();
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


    private void creaseCorundumMin(String name, String value) {

        TableColumn<SeniorityTable, String> tableColumn = new TableColumn<>(name);
        tableColumn.setCellValueFactory(new PropertyValueFactory<>(value));
        tableColumn.setMinWidth(Region.USE_COMPUTED_SIZE);
        tableColumn.setResizable(false);
        tableColumn.setSortable(false);
        tableColumns.add(tableColumn);

    }

    private void creaseCorundumMax(String name, String value) {
        TableColumn<SeniorityTable, String> tableColumn = new TableColumn<>(name);
        tableColumn.setCellValueFactory(new PropertyValueFactory<>(value));
        tableColumn.setMinWidth(100);
        tableColumn.setSortable(false);
        tableColumns.add(tableColumn);

    }
}
