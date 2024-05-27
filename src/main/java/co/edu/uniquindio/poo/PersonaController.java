package co.edu.uniquindio.poo;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;


//clase creada para el control de la scene
public class PersonaController {

    @FXML
    private TextArea areaTexto;

    @FXML
    private Button menu;

    @FXML
    void returnMenu(ActionEvent event) throws IOException {
        App.setRoot("menuPp");
    }

    //metodo inicia cuando se mueve el mouse y muestra el listado de motos que se han registrasdo en el parqueadero
    @FXML
    void iniciaTexto(MouseEvent event) {
        int counter=0;
        String texto="";
        for(Propietario buscarPropietario:App.dataBase.propietarios){
            
            for(Moto buscarMoto:App.dataBase.motos){
                if(buscarMoto.id==buscarPropietario.id){
                    counter++;
                    texto+=counter+"  id: "+ buscarMoto.id+ " moto con placa "+buscarMoto.getPlaca()+" modelo "+buscarMoto.getModelo()+" tipo "+buscarMoto.getTipo()+" con velocidad maxima "+buscarMoto.getVelocidadMax()+" Propietario "+buscarPropietario.getNombre()+" "+buscarPropietario.getApellido()+"\n\n";
                    break;         
                
                }
            }
        }
        areaTexto.setText(texto);
    } 

}