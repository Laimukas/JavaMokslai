package com.example.oopsesioliktapaskaita;

import com.example.oopsesioliktapaskaita.LaboratorinisNR3.AdresuKnygute;
import com.example.oopsesioliktapaskaita.LaboratorinisNR3.AdresuKnygutesKlaida;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    private AdresuKnygute adresuKnygute;

    @FXML
    private Label zmoniuSkaiciusText;

    @FXML
    private TextField miestasField;


    @FXML
    protected void surastiKiekZmoniuGyvenaOnClick() throws AdresuKnygutesKlaida {
        String miestas = miestasField.getText();
        int zmoniuKiekis = adresuKnygute.nurodytoMiestoGyventojuKiekioPaieska(miestas);
        zmoniuSkaiciusText.setText(String.format(miestas + " mieste yra: " + zmoniuKiekis + " gyventojai."));
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        adresuKnygute = new AdresuKnygute();
    }
}