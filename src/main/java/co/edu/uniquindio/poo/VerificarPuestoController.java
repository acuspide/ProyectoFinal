package co.edu.uniquindio.poo;

import java.io.IOException;
//import java.lang.reflect.InaccessibleObjectException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class VerificarPuestoController {

    @FXML
    private Button btBuscar;

    @FXML
    private TextField i;

    @FXML
    private TextField j;


    @FXML
    private Label lbId;

    @FXML
    private Label lbPropietario;

    @FXML
    private Label lbPuesto;

    @FXML
    private Button menu;

    @FXML
    void menu(ActionEvent event) throws IOException {
        App.setRoot("menuPp");
    }

    @FXML
    void verificarPuesto(ActionEvent event) {
        int[] puestoVerificar= new int[2];
        String respuesta="";
        puestoVerificar[0]=Integer.parseInt(i.getText());
        puestoVerificar[1]=Integer.parseInt(j.getText());
        respuesta=App.parqueadero.verificarPuesto(puestoVerificar);
        if(respuesta.equals("Lugar con formato errado ¡VERIFICAR!")){
            lbPropietario.setText(""); 
            lbPuesto.setText(respuesta);
            lbId.setText("");
        }else{
            if(respuesta.equals("Puesto Libre")){
                lbPropietario.setText("");
                lbPuesto.setText(respuesta);
                lbId.setText("");
            }else{
                lbPuesto.setText(respuesta);
                Lugar aux2=new Lugar(0,0, 0);
                for(Lugar aux:App.dataBase.getPuestos()){
                    if((aux.i==puestoVerificar[0])&&(aux.j==puestoVerificar[1])){
                        if(aux.id>aux2.id){
                            aux2.i=aux.i;
                            aux2.j=aux.j;
                            aux2.id=aux.id;
                            Propietario propietario=new Propietario(null, null, null, null, aux.getI());
                            propietario=App.dataBase.buscarPropietario(aux.id);
                            lbPropietario.setText(propietario.getNombre()+" "+propietario.getApellido());
                            lbPuesto.setText(respuesta);
                            lbId.setText(""+aux2.id);
                        }
                        
                    }
                }
            }
        }
        
    }   

}
