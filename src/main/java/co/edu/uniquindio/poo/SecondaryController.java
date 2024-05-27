package co.edu.uniquindio.poo;

import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SecondaryController {
    


    @FXML
    private Label TextApellido;

    @FXML
    private Button secondaryButton;

    @FXML
    private TextField textApellido;

    @FXML
    private TextField textCedula;

    @FXML
    private TextField textNombre;


    @FXML
    private ComboBox<String> boxTipo;

    @FXML
    private void FillBox(Event event) {
        ObservableList<String> tipoPersona = FXCollections.observableArrayList("Comprador","Propietario");
        boxTipo.setItems(tipoPersona);
    }
    

    @FXML
    private void switchToPrimary() throws IOException {
        
        if(boxTipo.getValue().equals("Propietario")){
            // Asignamos el id nuevo a la persona
            int[] puesto= new int[2];
            puesto=App.parqueadero.asignarPuesto();
            if(puesto[0]==-1){
                JOptionPane.showMessageDialog(null, "No hay puestos disponibles");
                App.setRoot("menuPp");
            }else{
                App.id++;
                Propietario propietario=new Propietario(textNombre.getText(),textApellido.getText(),textCedula.getText(),boxTipo.getValue(),0);
                System.out.println("guarda: "+propietario.nombre+" "+propietario.apellido);
                App.asignarPuesto(puesto);
                App.addPropietario(propietario);
                System.out.println("propietario creado "+propietario.tipo);
                App.setRoot("vehiculo");
            }
        }else{
                if(boxTipo.getValue().equals("Comprador")){
                    Persona persona=new Persona(textNombre.getText(),textApellido.getText(),textCedula.getText(),boxTipo.getValue());
                    System.out.println("guarda: "+persona.nombre+" "+persona.apellido);
                    App.addPerson(persona);
                    System.out.println("persona creada "+persona.tipo);
                    App.setRoot("persona");
                }
            }
        }           
}