package co.edu.uniquindio.poo;

public class Lugar {
    public int i;
    public int j;
    public int id;
    
    //clase creada para almacenar la posicion que ocupa un vehiculo en el parqueadero asociado a un id
    public Lugar(int i, int j, int id) {
        this.i=i;
        this.j=j;
        this.id = id;
    }


    public int getI() {
        return i;
    }


    public int getJ() {
        return j;
    }


    public int getId() {
        return id;
    }
    
}