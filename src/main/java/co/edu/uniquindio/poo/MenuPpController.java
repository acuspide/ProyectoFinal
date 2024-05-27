package co.edu.uniquindio.poo;

import java.io.IOException;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class MenuPpController {

    @FXML
    private Button btIngresoNew;

    @FXML
    private Button btMostrarBase;

    @FXML
    private Button btModificar;

    @FXML
    private Button btBuscarPuesto;
    
    @FXML
    private Button salida;

        @FXML
    private Label idReferencia;
    
    @FXML
    private Label libres;

    @FXML
    private Button reporteDiario;

    @FXML
    private Button reporteMes;

    //metodo que inicia con el movimiento el mouse que muestra el contador de id y los puestos libres en el parqueadero
    @FXML
    void incio(MouseEvent event) {
        idReferencia.setText(""+(App.id+1));
        libres.setText(""+App.parqueadero.numeroPuestos());
    }

    //metodo que redirecciona a la scene existentes y muestra en terminal los datos guardados en las listas
    @FXML
    void mostrarBase(ActionEvent event) throws IOException{
        App.motrarbase();
        App.setRoot("existentes");
    }

    //metodo que redirecciona scene a verificarPuesto
    @FXML
    void BuscarPuestoOcupado(ActionEvent event)throws IOException {
        App.setRoot("verificarPuesto");
        
    }

    //metodo que redirecciona a secondary
    @FXML
    void ingresarVehiculo(ActionEvent event)  throws IOException {
            
        App.setRoot("secondary");

    }
    
    //metodo que redirecciona a tarifas
    @FXML
    void modificarTarifa(ActionEvent event) throws IOException {

        App.setRoot("tarifas");

    }

    //metodo que redirecciona a salida
    @FXML
    void registroSalida(ActionEvent event) throws IOException {
        App.setRoot("salida");

    }

    //metodo que redirecciona a reporteDiario
    @FXML
    void rpDiario(ActionEvent event)throws IOException {
        App.setRoot("reporteDiario");
    }

    //metodo que redirecciona a reporte de mes
    @FXML
    void rpMes(ActionEvent event)throws IOException {
        App.setRoot("reporteMes");
    }



}