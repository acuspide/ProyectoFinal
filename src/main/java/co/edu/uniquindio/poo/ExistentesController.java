package co.edu.uniquindio.poo;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

//clase creada para mostrar los usuarios que se encuentran en el parqueadero

public class ExistentesController {

    @FXML
    private TextArea areaTexto;

    @FXML
    private Button menu;

    @FXML
    void returnMenu(ActionEvent event) throws IOException {
        App.setRoot("menuPp");
    }

    @FXML
    //metodo obtine los datoss de los usuarios parqueados que inicia cuando se mueve el mouse
    void iniciaTexto(MouseEvent event) {
        int counter=0;
        boolean flag=true;
        String texto="",textoFinal="";

        //recorre la lista de cliente propietarios comparando el id con los id de los vehiculos que ya salieron del parqueadero para solo mostar los existentes
        for(Propietario buscarPropietario:App.dataBase.propietarios){
            
            for(Moto buscarMoto:App.dataBase.motos){
                if(buscarMoto.id==buscarPropietario.id){
                    texto="  id: "+buscarPropietario.id+" Moto con placa "+buscarMoto.getPlaca()+" modelo "+buscarMoto.getModelo()+" tipo "+buscarMoto.getTipo()+" con velocidad maxima "+buscarMoto.getVelocidadMax()+" Propietario "+buscarPropietario.getNombre()+" "+buscarPropietario.getApellido();
                    //se guarda la informacion del propietario y la moto con el mismo id para mostrar
                    break;
                }
            }

            for(Carro buscarCarro:App.dataBase.carros){
                if(buscarCarro.id==buscarPropietario.id){
                    texto="  id: "+buscarPropietario.id+" Carro con placa "+buscarCarro.getPlaca()+" Propietario "+buscarPropietario.getNombre()+" "+buscarPropietario.getApellido();
                    //se guarda la informacion del propietario y la carro con el mismo id para mostrar
                    break;
                }
            }
    
            for(Lugar buscarPuesto:App.dataBase.puestos){
                if(buscarPuesto.id==buscarPropietario.id){
                    texto+=  " puesto " +buscarPuesto.getI()+" "+buscarPuesto.getJ()+"\n\n";
                    //se guardda el lugar asignado con el id del ppropietario para mostrar
                    break;
                }
            }
            
            for(FechaRegistro buscarFechaSalida:App.dataBase.salidas){
                if(buscarFechaSalida.id==buscarPropietario.id){
                    flag=false;
                    // se compara el id del comprado en la lista de los vehiculos que ya salieron para saber si ese vehiculo continua en el parquedero
                    break;
                }
            }
            
            //aqui se reconoce cuando un usuario salio del parqueadero y no muestre la informacion guardada o por lo contraio que la mueste y reinice la variable 
            if(flag){
                counter++;
                textoFinal+=counter+" "+texto;
                texto="";
            }else{
                flag=true;
            }
        }
        areaTexto.setText(textoFinal);//muestra los datos en area de texto en la scene
    } 

}
