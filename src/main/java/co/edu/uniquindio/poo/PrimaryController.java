package co.edu.uniquindio.poo;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


//clase creada para el control de la scene
public class PrimaryController {
    
    @FXML
    private Button primaryButton;

    @FXML
    private TextField TextNombre;

    @FXML
    private TextField TextPuestos;

    //metodo que para crear el parqueadero
    @FXML
    private void switchToSecondary() throws IOException {
        
        // Capturo los valores de los campos en el front 
        System.out.println( "Nombre: "+ TextNombre.getText() );
        System.out.println( "Puestos: "+ TextPuestos.getText() );

        // Creo el parqueadero
        App.crearParqueadero(Integer.parseInt(TextPuestos.getText()), TextNombre.getText()); 
    
        App.setRoot("menuPp");
    }
}
