package ru.bkmz.kurs.util.logik;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import ru.bkmz.kurs.util.Plant.Notification;

import java.util.ArrayList;
import java.util.Arrays;

import static ru.bkmz.kurs.util.logik.RegularExpressions.expression;


public class BuilderFunction {
    private ArrayList<Text> texts = new ArrayList<>();
    private ArrayList<TextField> textFields = new ArrayList<>();
    private HBox hBox = new HBox();

    private TextArea textAreaInf;

    BuilderFunction(String functions, Button score, String inf, VBox vBox) {
        textAreaInf = textAreaBuild(inf);
        String[] elements = functions.split(",");
        for (int i = 0; i < elements.length; i++) {
            if (i % 2 == 0) {
                if(!elements[i].equals("*1")) {
                    texts.add(textBuild(elements[i]));
                }
            } else {
                textFields.add(textFieldBuild("", elements[i]));
            }
        }


        for (int i = 0; i < texts.size(); i++) {
            hBox.getChildren().add(texts.get(i));
            try {
                hBox.getChildren().add(textFields.get(i));
            } catch (Exception e) {
            }

        }
        Text out = textBuild("=?");
        hBox.getChildren().add(out);
        score.setOnMouseClicked(event -> {
            StringBuilder urav = new StringBuilder();
            boolean foll = true;
            for (int i = 0; i < texts.size(); i++) {

                if ((i != 0)) {
                    String txt = texts.get(i).getText();

                    urav.append(txt);

                }
                if (i == 0) {
                    String s =texts.get(i).getText().replace("(",",^");
                    String[] txt = (s.split(","));
                    for (int j = 0; j < txt.length-1; j++) {


                        urav.append("(");
                    }
                }
                try {
                    String txt = textFields.get(i).getText();
                    if (!txt.equals("")) {
                        urav.append(txt);
                    } else {
                        foll = false;
                    }
                }catch (Exception e){}



            }
            if (foll) {
                String s = urav.toString().replace(":", "/").replace(",", ".").replace("×", "*");
                System.out.println(s);
                out.setText("=" + expression(s));
            } else {
                new Notification("Уведомление", "Заполниет все поля");
            }
        });
        VBox.setVgrow(hBox, Priority.ALWAYS);
        vBox.getChildren().addAll(hBox, textAreaInf);

    }

    public TextArea getTextAreaInf() {
        return textAreaInf;
    }

    public void setTextAreaInf(TextArea textAreaInf) {
        this.textAreaInf = textAreaInf;
    }

    HBox gethBox() {
        return hBox;
    }

    void sethBox(HBox hBox) {
        this.hBox = hBox;
    }

    ArrayList<Text> getTexts() {
        return texts;
    }

    void setTexts(ArrayList<Text> texts) {
        this.texts = texts;
    }

    ArrayList<TextField> getTextFields() {
        return textFields;
    }

    void setTextFields(ArrayList<TextField> textFields) {
        this.textFields = textFields;
    }


    private TextArea textAreaBuild(String value) {
        TextArea textArea = new TextArea(value);
        VBox.setVgrow(textArea, Priority.ALWAYS);
        HBox.setHgrow(textArea, Priority.ALWAYS);
        textArea.setEditable(false);
        textArea.setWrapText(true);
        return textArea;
    }

    private TextField textFieldBuild(String value, String promptText) {
        TextField textField = new TextField(value);
        textField.setPromptText(promptText);
        VBox.setVgrow(textField, Priority.ALWAYS);
        HBox.setHgrow(textField, Priority.ALWAYS);
        //textField.setId("text");
        textProperty(textField);
        return textField;
    }

    private Text textBuild(String value) {
        Text text = new Text(value);
        text.setId("text");
        VBox.setVgrow(text, Priority.ALWAYS);
        HBox.setHgrow(text, Priority.ALWAYS);
        return text;
    }


    private void textProperty(TextField textField) {
        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("[\\d*,.()*/+-:]")) {
                    textField.setText(newValue.replaceAll("[^\\d,.*/+()-:]", ""));
                }
            }
        });
    }

}
