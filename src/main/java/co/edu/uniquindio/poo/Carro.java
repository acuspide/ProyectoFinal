package co.edu.uniquindio.poo;
//clase carro con sus atributos
public class Carro{
    public String placa;
    public String modelo;
    public double tarifa;
    public int id;

    public Carro(String placa, String modelo, int id, double tarifa){
        this.placa=placa;
        this.modelo=modelo;
        this.id=id;
        this.tarifa=tarifa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public double getTarifa() {
        return tarifa;
    }

    public int getId() {
        return id;
    }
    

}