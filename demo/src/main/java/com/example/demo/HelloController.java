package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private TextField name;

    @FXML
    private TextField surname;

    @FXML
    private TextField age;

    @FXML
    private Label errorText;

    @FXML
    private TableView<Person> persons;

    @FXML
    private TableColumn<Person, String> vardas;

    @FXML
    private TableColumn<Person, String> pavarde;

    @FXML
    private TableColumn<Person, Integer> metai;

    private ArrayList<Person> personArrayList = new ArrayList<>();

    @FXML
    protected void onButtonClick() {
        try{
            int ageAsNumber = Integer.parseInt(age.getText());

            if(ageAsNumber < 18){
                errorText.setText(name.getText() + " yra nepilnametis");
                makeTextEmpty();
            } else {
                personArrayList.add(new Person(name.getText(), surname.getText(), ageAsNumber));
                updateTable(FXCollections.observableArrayList(personArrayList));
                makeTextEmpty();
            }
        } catch (Exception e){
            errorText.setText("Ivestas ne skaicius");
        }
    }

    private void makeTextEmpty() {
        name.setText("");
        surname.setText("");
        age.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Person> list = FXCollections.observableArrayList(new ArrayList<>());
        updateTable(list);
    }

    public void updateTable(ObservableList<Person> list){
        vardas.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
        pavarde.setCellValueFactory(new PropertyValueFactory<Person, String>("surname"));
        metai.setCellValueFactory(new PropertyValueFactory<Person, Integer>("age"));
        persons.setItems(list);
    }
}