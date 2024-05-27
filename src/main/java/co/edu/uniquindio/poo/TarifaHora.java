package co.edu.uniquindio.poo;


//clase creada para el manejo de tarifas de cada tipo de vehiculo
public class TarifaHora {

    public double clasica;
    public double hibrida;
    public double carro;

    public TarifaHora(){
        clasica=1000;
        hibrida=800;
        carro=2500;

    }

    //metodo que calcula el costo por minuto que el vehiculo permanecio en el parqueadero y la tarefa asignada en el ingreso
    public double cobro(long tiempo, double cobroHora){
        double calculo=0;
        calculo=tiempo*(cobroHora/60);
        return calculo;
    }
    
}