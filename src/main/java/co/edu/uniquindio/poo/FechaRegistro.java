package co.edu.uniquindio.poo;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


//clase creada para el registro horario de entras y salidas de los usuarios
public class FechaRegistro {
    public LocalDateTime fechaRegistrada;
    public int id;

    public FechaRegistro(int id){
        this.id=id;

    }
    
    //cuando este metodo es convocado retorna la frecha del momento y la guarda en uno de sus atributos para ser guardada directamente en la base de datos
    public LocalDateTime registroHorario(){
        fechaRegistrada= LocalDateTime.now();
        return fechaRegistrada;
    }

    //metododo que calcula la diferencia de 2 fechas y retorna la direncia en minutos
    public long tiempoOcupacion(LocalDateTime entrada, LocalDateTime salida){
        long minutos = ChronoUnit.MINUTES.between(entrada, salida);

        return minutos;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getFechaRegistrada() {
        return fechaRegistrada;
    }
    
}