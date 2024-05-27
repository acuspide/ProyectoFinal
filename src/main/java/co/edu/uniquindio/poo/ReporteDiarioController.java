package co.edu.uniquindio.poo;

import java.io.IOException;
import java.time.LocalDateTime;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

//clase creada para el control de la scene
public class ReporteDiarioController {

    @FXML
    private Button menu;

    @FXML
    private TextArea areaTexto;

    
    @FXML
    private Button btMostrar;

    //metodo que redirecciona al menu
    @FXML
    void returnMenu(ActionEvent event) throws IOException {

        App.setRoot("menuPp");
        }
    
    //metodo para mostrar todos los reportes diarios 
    @FXML
    void visualizarDatos(ActionEvent event) {

        double costodiario=0;
        int counter=0;
        String texto="",textoFinal="";
        for(FechaRegistro registro:App.dataBase.salidas){
            System.out.println(""+registro.tiempoOcupacion(registro.fechaRegistrada, LocalDateTime.now()));
            //se define que el rango de los vehiculos que han facturado salidas es menor a 1440 minutos que equivalen al ultimo dia desde el momento actual
            if(registro.tiempoOcupacion(registro.fechaRegistrada, LocalDateTime.now())<=1440){
                System.out.println("encuentra salida id: "+registro.id);
                
                //se busca en la base de dato las salidas que cumplen el requerimiento del ultimo dia
                for(Propietario buscarPropietario:App.dataBase.propietarios){
                    System.out.println(""+buscarPropietario.id);
                    if(buscarPropietario.id==registro.id){
                        texto=" Propietario "+buscarPropietario.getNombre()+" "+buscarPropietario.getApellido()+"\n";
                        break;
                    }
                
                }
                for(Moto buscarMoto:App.dataBase.motos){
                    if(buscarMoto.id==registro.id){
                        texto+="   Moto con placa "+buscarMoto.getPlaca()+" modelo "+buscarMoto.getModelo()+" tipo "+buscarMoto.getTipo()+" con velocidad maxima "+buscarMoto.getVelocidadMax()+"\n";
                        break;
                    }
                }
    
                for(Carro buscarCarro:App.dataBase.carros){
                    if(buscarCarro.id==registro.id){
                        texto+="   Carro con placa "+buscarCarro.getPlaca()+" modelo "+buscarCarro.getModelo()+"\n";
                        break;
                    }
                }
        
                for(Lugar buscarPuesto:App.dataBase.puestos){
                    if(buscarPuesto.id==registro.id){
                        texto+=  "  puesto " +buscarPuesto.getI()+" "+buscarPuesto.getJ()+"\n";
                        break;
                    }
                }
                
                //se suman los cobros registrados por las salidas segun id y se muestran un un string que esta guardon los datos del propietario vehiculo puesto
                for(Cobro cobro:App.dataBase.cobros){
                    if(cobro.id==registro.id){
                        texto+=  "  Pago: " +cobro.calculo+"\n\n";
                        counter++;
                        textoFinal+=counter+" "+texto;
                        texto="";
                        costodiario+=cobro.calculo;
                        break;
                    }
                }  
            }
        }
        //se muestra en la scene
        areaTexto.setText(textoFinal+"\nel recaudo total del dia es de: "+costodiario);
    }

}

