package co.edu.uniquindio.poo;

//clase crada para gradar la informacion de los compradores

public class Persona {
    
    public String nombre;
    public String apellido;
    public String cedula;
    public String tipo;

    public Persona(String nombre, String apellido, String cedula, String tipo){
        this.nombre=nombre;
        this.apellido=apellido;
        this.cedula=cedula;
        this.tipo=tipo;
        
        
    }

    public String getTipo() {
        return tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCedula() {
        return cedula;
    }
    
}
    

