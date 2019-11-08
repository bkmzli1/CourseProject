package ru.bkmz.kurs.util.Plant;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.ArrayList;

public class PlanetDAO {
    private static ObservableList<Planet> list;
    static ArrayList<Planet> arrayList = new ArrayList();
    public static ObservableList<Planet> getPlanetList() {
        return list;
    }

    public static void load(String code, String name) {
        Planet earth = new Planet(code, name);
        arrayList.add(earth);

        reload();
    }
    private static void reload(){
        list = FXCollections.observableArrayList(arrayList);
    }
}
