package co.edu.uniquindio.poo;
//clase creada para guardar los saldos pagados por los usuario y asignar el id del mismo
public class Cobro {
    public double calculo;
    public int id;

    public Cobro(double calculo, int id){
        this.id=id;
        this.calculo=calculo;
    }

    public double getCalculo() {
        return calculo;
    }


    
}