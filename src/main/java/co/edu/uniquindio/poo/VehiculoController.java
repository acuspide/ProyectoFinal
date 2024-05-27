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

public class VehiculoController {

    @FXML
    private ComboBox<String> boxTipo;

    @FXML
    private Label lbMvel;

    @FXML
    private TextField textMVel;

    @FXML
    private TextField textModelo;

    @FXML
    private TextField textPlaca;

    @FXML
    private Button btCrear;

    @FXML
    private void crearVehiculo(ActionEvent event)  throws IOException {
        if(boxTipo.getValue().equals("Carro")){
            
            Carro carro=new Carro(textPlaca.getText(), textModelo.getText(), 0, App.dataBase.tarifa.carro);
            System.out.println("ingresa carro");
            App.addCarro(carro);

        }else{            
            System.out.println("ingresa moto");
            if( boxTipo.getValue().equals("clasica")){
                Moto moto=new Moto(Integer.parseInt(textMVel.getText()), boxTipo.getValue(), textPlaca.getText(), textModelo.getText(), 0, App.dataBase.tarifa.clasica);
                App.addMoto(moto);
            }else{
                Moto moto=new Moto(Integer.parseInt(textMVel.getText()), boxTipo.getValue(), textPlaca.getText(), textModelo.getText(), 0, App.dataBase.tarifa.hibrida);
                App.addMoto(moto);
            }
        }

        FechaRegistro fechaRegistro= new FechaRegistro(0);
        App.addFechaIngreso(fechaRegistro);
        App.setRoot("menuPp");
    }

    @FXML
    private void escogerVehiculo(Event event) {
        System.out.println("escogerVehiculo");
        if (boxTipo.getValue().equals("Carro") ) {
            lbMvel.setDisable(true);
            textMVel.setDisable(true);
        }
        else {
            lbMvel.setDisable(false);
            textMVel.setDisable(false);    
        }        

    }

    @FXML
    void FillBox(Event event) {
        ObservableList<String> tipoPersona = FXCollections.observableArrayList("Carro","Moto clasica","Moto hibrida");
        System.out.println("Fillbox");
        boxTipo.setItems(tipoPersona);

    }
}
