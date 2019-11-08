package ru.bkmz.kurs.util.Plant;

import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class Planet {


    public String code;
    private String name;

    public Planet() {


    }

    public Planet(String code, String name) {

        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
