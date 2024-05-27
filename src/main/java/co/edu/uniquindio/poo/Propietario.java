package co.edu.uniquindio.poo;

//clase creada para almacenar la informacion de los propietarios. esta clase hereda de persona

public class Propietario extends Persona{
    public int id;

    public Propietario(String nombre, String apellido, String cedula, String tipo, int id) {
        super(nombre, apellido, cedula, tipo);
        this.id=id;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }    
}
