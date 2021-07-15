package it.unicam.cs.pa2021.formulaUno.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ResourceBundle;

public class JavaFxFirstWindow implements Initializable {

    @FXML
    private ComboBox<String> comboBoxChoiceFields;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> options = FXCollections.observableArrayList("circuito piccolo (3 giocatori)", "circuito medio (4 giocatori");
        comboBoxChoiceFields = new ComboBox<>(options);
    }

    public void clickContinue(javafx.event.ActionEvent actionEvent) {
        if(!comboBoxChoiceFields.getValue().equals("")){
            if(comboBoxChoiceFields.getValue().equals("circuito piccolo (3 giocatori)"))
                System.out.println("a");
        }
    }
}
