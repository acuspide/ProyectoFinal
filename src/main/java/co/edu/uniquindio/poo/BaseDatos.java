package co.edu.uniquindio.poo;

import java.util.Collection;
import java.util.LinkedList;

public class BaseDatos {
    public Collection<Persona>personas;
    public Collection<Propietario>propietarios;
    public Collection<Moto>motos;
    public Collection<Carro>carros;
    public Collection<FechaRegistro>llegadas;
    public Collection<FechaRegistro>salidas;
    public Collection<Cobro>cobros;
    public Collection<Lugar>puestos;
    public TarifaHora tarifa;
    
    public BaseDatos(){
        //inicializacion de listas  y atributos que sirven como base de datos
        personas = new LinkedList<>();
        propietarios = new LinkedList<>();
        motos = new LinkedList<>();
        carros = new LinkedList<>();
        llegadas = new LinkedList<>();
        salidas = new LinkedList<>();
        cobros = new LinkedList<>();
        puestos = new LinkedList<>();
        tarifa = new TarifaHora();
    }



    public Propietario buscarPropietario(int idBuscar){
        Propietario buscado=new Propietario(null, null, null, null, idBuscar);
        for(Propietario propietario:propietarios){
            if(idBuscar==propietario.getId()){
                buscado=propietario;
            }
        }
        return buscado;
    }

    public Moto buscarMoto( int idBuscar){

        Moto moto=new Moto(0, null, null, null, 0, 0);
        
        for(Moto buscarMoto:App.dataBase.motos){
            if(idBuscar==buscarMoto.getId()){
                moto=buscarMoto;    
            }
        }
        return moto;
    }

    public Carro buscarCarro( int idBuscar){

        Carro carro=new Carro(null, null, idBuscar, 0);

        for(Carro buscarCarro:App.dataBase.carros){
            if(idBuscar==buscarCarro.getId()){
                carro=buscarCarro;
            }
        }
        return carro;
        
    }

    public Lugar buscaPuesto(int idBuscar){
        Lugar puesto=new Lugar(0, 0, 0);
        for(Lugar buscarPuesto:App.dataBase.puestos){
            if(buscarPuesto.id==idBuscar){
                puesto=buscarPuesto;
            }
        }
        return puesto;
    }

    public FechaRegistro buscaFechaLlegada(int idBuscar){
        FechaRegistro llegada=new FechaRegistro(0);
        for(FechaRegistro buscarLlegada:App.dataBase.llegadas){
            if(buscarLlegada.id==idBuscar){
                llegada=buscarLlegada;
            }
        }
        return llegada;
    }
    
    public FechaRegistro buscaFechaSalida(int idBuscar){
        FechaRegistro salida=new FechaRegistro(0);
        for(FechaRegistro buscarSalida:App.dataBase.salidas){
            if(buscarSalida.id==idBuscar){
                salida=buscarSalida;
            }
        }
        return salida;
    }

        


    public Collection<Persona> getPersonas() {
        return personas;
    }

    public Collection<Moto> getMotos() {
        return motos;
    }

    public Collection<Carro> getCarros() {
        return carros;
    }

    public Collection<FechaRegistro> getLlegadas() {
        return llegadas;
    }

    public Collection<FechaRegistro> getSalidas() {
        return salidas;
    }

    public Collection<Cobro> getCobros() {
        return cobros;
    }

    public Collection<Lugar> getPuestos() {
        return puestos;
    }

    public TarifaHora getTarifa() {
        return tarifa;
    }

    public Collection<Propietario> getPropietarios() {
        return propietarios;
    }   

}