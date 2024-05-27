package co.edu.uniquindio.poo;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class TarifasController {

    @FXML
    private TextField TextValor;

    @FXML
    private ComboBox<String> boxTipo;

    @FXML
    private Button btModificar;

    @FXML
    private Label lbTarifaCarro;

    @FXML
    private Label lbTarifaClasica;

    @FXML
    private Label lbTarifaHibrida;



    @FXML
    void FillBox(Event event) {
        ObservableList<String> modificar = FXCollections.observableArrayList("Carro","Moto clasica","Moto hibrida");
        System.out.println("Fillbox");
        boxTipo.setItems(modificar);

    }
    
    @FXML
    private void escogerTarifa(Event event) {
        System.out.println("escogerTarifa");
        System.out.println(boxTipo.getValue());

       
    }

    @FXML
    void inicio(MouseEvent event) {

        lbTarifaCarro.setText(""+App.dataBase.tarifa.carro); 
        lbTarifaClasica.setText(""+App.dataBase.tarifa.clasica);
        lbTarifaHibrida.setText(""+App.dataBase.tarifa.hibrida);

    }

    @FXML
    void modificar(ActionEvent event) throws IOException {
        

        if ((boxTipo.getValue()+"").equals("Carro") ) {
            App.dataBase.tarifa.carro=Integer.parseInt(TextValor.getText());
            
        }
        else {
            if(boxTipo.getValue().equals("Moto clasica")){
                App.dataBase.tarifa.clasica=Integer.parseInt(TextValor.getText());
            }else{
                App.dataBase.tarifa.hibrida=Integer.parseInt(TextValor.getText());
            }
        }
        System.out.println(boxTipo.getValue());
        App.setRoot("menuPp");
    
    }
}




