package ru.bkmz.kurs.util.logik.seniority;

import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.text.Text;
import javafx.util.StringConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SeniorityTable {
    private Text id;

    private DatePicker dataReception, dateDismissal;
    private Button remove;

    public SeniorityTable(String id, DatePicker datePickerR, DatePicker DatePickerD) {
        this.id = new Text(id);
        StringConverter<LocalDate> converter = new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter =
                    DateTimeFormatter.ofPattern("dd/MM/yyyy");

            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }
            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        };
        this.id.setId("text");
        this.dataReception = datePickerR;
        this.dateDismissal = DatePickerD;
        this.dataReception.setMaxWidth(Double.MAX_VALUE);
        this.dataReception.setPromptText("dd/MM/yyyy");
        this.dataReception.setConverter(converter);;
        this.dateDismissal.setMaxWidth(Double.MAX_VALUE);
        this.dateDismissal.setPromptText("dd/MM/yyyy");
        this.dateDismissal.setConverter(converter);
    }

    public Text getId() {
        return id;
    }

    public void setId(Text id) {
        this.id = id;
    }

    public DatePicker getDataReception() {
        return dataReception;
    }

    public void setDataReception(DatePicker dataReception) {
        this.dataReception = dataReception;
    }

    public DatePicker getDateDismissal() {
        return dateDismissal;
    }

    public void setDateDismissal(DatePicker dateDismissal) {
        this.dateDismissal = dateDismissal;
    }

    public Button getRemove() {
        return remove;
    }

    public void setRemove(Button remove) {
        this.remove = remove;
    }
}
