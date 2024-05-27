package co.edu.uniquindio.poo;


//clase moto con sus atributos que herda de carro
public class Moto extends Carro{
    public double velocidadMax;
    public String tipo;
    
    public Moto(double velocidadMax, String tipo, String placa, String modelo, int id, double tarifa){
        super(placa,modelo, id, tarifa);
        this.velocidadMax=velocidadMax;
        this.tipo=tipo;
    }

    public double getVelocidadMax() {
        return velocidadMax;
    }

    public String getTipo() {
        return tipo;
    }
}
