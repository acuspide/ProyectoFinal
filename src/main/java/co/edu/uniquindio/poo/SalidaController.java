package co.edu.uniquindio.poo;

import java.io.IOException;
//import java.time.LocalDate;
import java.time.LocalDateTime;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SalidaController {

    @FXML
    private Label PuestoSalida;

    @FXML
    private Button btCancelar;

    @FXML
    private Button buscarId;

    @FXML
    private Button buscarPlaca;

    @FXML
    private Label costoActual;

    @FXML
    private Label idRetiro;

    @FXML
    private Label nombreSalida;

    @FXML
    private Label placaSalida;

    @FXML
    private Button registroSalida;

    @FXML
    private TextField textId;

    @FXML
    private TextField textPlaca;

    @FXML
    void buscarPorPlaca(ActionEvent event) {

        //String placa=textPlaca.getText();
        int idBuscar=0;
        System.out.println("busca por placa");
        double tarifa=0;

        for(Moto buscarMoto:App.dataBase.motos){
            if(textPlaca.getText().equals(buscarMoto.getPlaca())){
                idRetiro.setText(""+buscarMoto.id);
                textId.setText(""+buscarMoto.id);
                placaSalida.setText("moto de placa "+buscarMoto.getPlaca()+" tipo "+buscarMoto.getTipo());
                System.out.println("id moto"+buscarMoto.id);
                textPlaca.setText(buscarMoto.getPlaca());                      
                idBuscar=buscarMoto.id;
                tarifa=buscarMoto.tarifa;
            }
        }
        for(Carro buscarCarro:App.dataBase.carros){
            if(textPlaca.getText().equals(buscarCarro.getPlaca())){
                idRetiro.setText(""+buscarCarro.id);
                textId.setText(""+buscarCarro.id);
                placaSalida.setText("carro de placa "+buscarCarro.placa);
                System.out.println("id carro"+buscarCarro.id);       
                idBuscar=buscarCarro.id;
                textPlaca.setText(buscarCarro.getPlaca());
                tarifa=buscarCarro.tarifa;
            }
        }

        textId.setText(""+idBuscar);
        idRetiro.setText(""+idBuscar);
        Propietario propietario=new Propietario(null, null, null, null, idBuscar);
        propietario=App.dataBase.buscarPropietario(idBuscar);
        Lugar puesto=new Lugar(0, 0, 0);
        puesto=App.dataBase.buscaPuesto(idBuscar);
        FechaRegistro ingreso=new FechaRegistro(0);
        ingreso=App.dataBase.buscaFechaLlegada(idBuscar);

        nombreSalida.setText(propietario.getNombre()+" "+propietario.getApellido());
        PuestoSalida.setText(puesto.i+"-"+puesto.j);
        costoActual.setText(""+App.dataBase.tarifa.cobro(ingreso.tiempoOcupacion(ingreso.fechaRegistrada, LocalDateTime.now()),tarifa));
    }
    


    @FXML
    void busquedaPorId(ActionEvent event) {
        System.out.println("ingresa a busqueda por id");
        int idBuscar=Integer.parseInt(textId.getText());
        System.out.println("busqueda por el id "+idBuscar);
        idRetiro.setText(""+idBuscar);
        System.out.println("id para buscar "+idBuscar); 
        System.out.println("busca propietario");
        for(Propietario propietario:App.dataBase.propietarios){
            if(idBuscar==propietario.getId()){
                nombreSalida.setText(propietario.getNombre()+" "+propietario.getApellido());
                
            }
        }
        System.out.println("busca vehiculo moto");
    
        for(Moto buscarMoto:App.dataBase.motos){
            if(idBuscar==buscarMoto.getId()){
                placaSalida.setText("moto de placa "+buscarMoto.getPlaca()+" tipo "+buscarMoto.getTipo());
                textPlaca.setText(buscarMoto.getPlaca());
                for(FechaRegistro registroIn:App.dataBase.llegadas){
                    if(registroIn.id==idBuscar){
                        System.out.println("moto");
                        costoActual.setText(""+App.dataBase.tarifa.cobro(registroIn.tiempoOcupacion(registroIn.fechaRegistrada, LocalDateTime.now()),buscarMoto.getTarifa()));

                    }
                }
            }
        }

        System.out.println("busca vehiculo carro");

        for(Carro buscarCarro:App.dataBase.carros){
            if(idBuscar==buscarCarro.getId()){
                placaSalida.setText("Carro de placa "+buscarCarro.getPlaca());
                textPlaca.setText(buscarCarro.getPlaca());
                for(FechaRegistro registroIn:App.dataBase.llegadas){
                    if(registroIn.id==idBuscar){
                        System.out.println("carro");
                        costoActual.setText(""+App.dataBase.tarifa.cobro(registroIn.tiempoOcupacion(registroIn.fechaRegistrada, LocalDateTime.now()),buscarCarro.getTarifa()));

                    }
                }
            }
        }
        for(Lugar buscarPuesto:App.dataBase.puestos){
            if(buscarPuesto.id==idBuscar){
                PuestoSalida.setText(buscarPuesto.i+"-"+buscarPuesto.j);
            }
        }
    }
        

   
        

    @FXML
    void cancelarSalida(ActionEvent event) throws IOException {
        App.setRoot("menuPp");
    }

    @FXML
    void realizarSalida(ActionEvent event) throws IOException {
       
        FechaRegistro salida=new FechaRegistro(Integer.parseInt(textId.getText()));
        Cobro cobro=new Cobro(Double.parseDouble(costoActual.getText()), Integer.parseInt(textId.getText()));
        salida.registroHorario();
        App.dataBase.salidas.add(salida);
        App.dataBase.cobros.add(cobro);
    
        for(Lugar buscarPuesto:App.dataBase.puestos){
            if(buscarPuesto.id==Integer.parseInt(idRetiro.getText())){
                int[] liberar=new int[2];
                liberar[0]=buscarPuesto.i;
                liberar[1]=buscarPuesto.j;
                App.parqueadero.librerarPuesto(liberar);
                break;
            }
        }
        App.setRoot("menuPp");
    }

}