package co.edu.uniquindio.poo;

import java.io.IOException;
import java.time.LocalDateTime;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ReporteMesController {

    @FXML
    private Button btMostrar;

    @FXML
    private Label costoTotal;

    @FXML
    private Button menu;


    @FXML
    void returnMenu(ActionEvent event)  throws IOException {

        App.setRoot("menuPp");
    }

    @FXML
    void visualizarCosto(ActionEvent event) {
        double costoMes=0;
        for(FechaRegistro registro:App.dataBase.salidas){
            if(registro.tiempoOcupacion(registro.fechaRegistrada, LocalDateTime.now())<=43200){
                for(Cobro cobro:App.dataBase.cobros){
                    if(cobro.id==registro.id){                        
                        costoMes+=cobro.calculo;
                        break;
                    }
                }
                    
            }
        }
        costoTotal.setText(""+costoMes);
    }

}
    
