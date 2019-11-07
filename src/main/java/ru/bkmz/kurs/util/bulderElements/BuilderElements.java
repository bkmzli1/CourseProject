package ru.bkmz.kurs.util.bulderElements;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import javax.swing.*;

public class BuilderElements {
    public static TextArea textAreaBuild(String value) {
        TextArea textArea = new TextArea(value);

        textArea.setMaxHeight(Double.MAX_VALUE);
        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setEditable(false);
        textArea.setWrapText(true);
        HBox.setHgrow(textArea, Priority.ALWAYS);
        VBox.setVgrow(textArea, Priority.ALWAYS);
        return textArea;
    }

    public static TextField textFieldBuild(String value, String promptText) {
        TextField textField = new TextField(value);
        textField.setPromptText(promptText);
        HBox.setHgrow(textField, Priority.ALWAYS);
        VBox.setVgrow(textField, Priority.ALWAYS);
        //textField.setId("text");
        textProperty(textField);
        return textField;
    }

    public static Text textBuild(String value) {
        Text text = new Text(value);
        text.setId("text");
        HBox.setHgrow(text, Priority.ALWAYS);
        VBox.setVgrow(text, Priority.ALWAYS);
        return text;
    }


    private static void textProperty(TextField textField) {
        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("[\\d*,.()*/+-:]")) {
                    textField.setText(newValue.replaceAll("[^\\d,.*/+()-:]", ""));
                }
            }
        });
    }
    public  static Button ButtonBuild(String value){
        Button button = new Button(value);
        button.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(button, Priority.ALWAYS);
        VBox.setVgrow(button, Priority.ALWAYS);
        return button;
    }
    public static HBox hBoxBulder(){
        HBox hBox = new HBox(10);
        HBox.setHgrow(hBox, Priority.ALWAYS);
        VBox.setVgrow(hBox, Priority.ALWAYS);
        return hBox;
    }
    public static VBox vBoxBulder(){
        VBox hBox = new VBox(10);
        HBox.setHgrow(hBox, Priority.ALWAYS);
        VBox.setVgrow(hBox, Priority.ALWAYS);
        return hBox;
    }
}
