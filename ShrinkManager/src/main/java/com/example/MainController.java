// MainController.java
package com.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import java.util.Comparator;

public class MainController {

    @FXML
    private TextField txtImie;

    @FXML
    private TextField txtNazwisko;

    @FXML
    private TextField txtWiek;

    @FXML
    private ChoiceBox<String> choiceSort;

    private final ObservableList<Pacjent> listaPacjentow = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        choiceSort.getItems().addAll("Imienia", "Nazwiska", "Wieku", "Kolejności dodania");
        choiceSort.setValue("Nazwiska");
    }

    @FXML
    private void handleAddAction() {
        // ...
    }

    @FXML
    private void handlePrintAction() {
        // ...
    }
}
