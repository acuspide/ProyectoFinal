package co.edu.uniquindio.poo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;



/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    //se crea una base donde guardar la informacion de los usuarios al igual que se crea el parqueadero segun el numero de puestos que indique el administrador del lugar o programa
    static BaseDatos dataBase=new BaseDatos();
    static Parqueadero parqueadero;
    static int id=0;


    @Override
    public void start(Stage stage) throws IOException {
        // se establece una tarifa por hora estadar para iniciar el parqueadero la cual se ppuede modificar
        TarifaHora tarifa=new TarifaHora();
        dataBase.tarifa=tarifa;          
       
        // Aqui se configura que ventana abre primero
        
        scene = new Scene(loadFXML("primary"));
        stage.setScene(scene);
        stage.show();        
    }

    //se crea el parqueadero con los numeros de puestos ingresados
    static void crearParqueadero(int puestos, String nombre) throws IOException {
        parqueadero=new Parqueadero(puestos, nombre);
        
    }

        //añade un propietario la base de datos y se le asiga un id
    static void addPropietario(Propietario propietario) throws IOException {
        propietario.id =id;
        // Agregamos la persona ala BD
        dataBase.propietarios.add(propietario);
    }

    // añade un comprador a la base de datos
    static void addPerson(Persona persona) throws IOException {
        dataBase.personas.add(persona);
    }

        //añade una moto a la base de datos y se le asigna un id
    static void addMoto(Moto moto) throws IOException {
        // Asignamos el id nuevo al vehiculo
        moto.id = id;
        // Agregamos la persona ala BD
        dataBase.motos.add(moto);
    }

    static void addCarro(Carro carro) throws IOException {
        // Asignamos el id nuevo al vehiculo
        carro.id = id;
        // Agregamos la persona ala BD
        dataBase.carros.add(carro);
    }

    static void addFechaIngreso(FechaRegistro fecha) throws IOException {
        // Asignamos el id nuevo a la fecha
        fecha.id = id;
        fecha.registroHorario();
        // Agregamos la persona ala BD
        dataBase.llegadas.add(fecha);
    }

    //agrega el numero de puesto a la baase de datos y se le asigna un id
    static void asignarPuesto(int[]puesto) throws IOException {
        Lugar lugar=new Lugar(puesto[0], puesto[1], id);
         dataBase.puestos.add(lugar);        
    }

    //metodo que sirve para ver los vehiculos existentes en la base de dato completa en el terminal
    static void motrarbase(){
        int counter=0;
            
        for(Propietario buscarPropietario:dataBase.propietarios){
            counter++;

            System.out.println(counter+" Propietario "+buscarPropietario.getNombre()+" "+buscarPropietario.getApellido()+" con numero de cedula:"+buscarPropietario.getCedula());
                
            for(Moto buscarMoto:dataBase.motos){
                if(buscarMoto.id==buscarPropietario.id){
                    System.out.println("  moto con placa "+buscarMoto.getPlaca()+" modelo "+buscarMoto.getModelo()+" tipo "+buscarMoto.getTipo()+" con velocidad maxima "+buscarMoto.getVelocidadMax());
                    break;
                }
            }

            for(Carro buscarCarro:dataBase.carros){
                if(buscarCarro.id==buscarPropietario.id){
                    System.out.println("  carro con placa "+buscarCarro.getPlaca());
                    break;
                }
            }

            for(FechaRegistro buscarFechaRegistro:dataBase.llegadas){
                if(buscarFechaRegistro.id==buscarPropietario.id){
                    System.out.println("  fecha de ingreso "+buscarFechaRegistro.fechaRegistrada);
                    break;
                }
            }
            for(FechaRegistro buscarFechaRegistro:dataBase.salidas){
                if(buscarFechaRegistro.id==buscarPropietario.id){
                    System.out.println("  fecha de salida "+buscarFechaRegistro.fechaRegistrada);
                    break;
                }
            }

            for(Cobro cobro:dataBase.cobros){
                if(cobro.id==buscarPropietario.id){
                    System.out.println("  pago: "+cobro.calculo);
                    break;
                }
            }

            for(Lugar buscarPuesto:dataBase.puestos){
                if(buscarPuesto.id==buscarPropietario.id){
                    System.out.println("  puesto "+buscarPuesto.getI()+" "+buscarPuesto.getJ()+"\n");
                    break;
                }
            }        
        }
}
    
    //metodo para abrir varios screen por el nombre del archivo fxml
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
    //metodo para abrir varios screen por el nombre del archivo fxml
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    

    public static void main(String[] args) {

        launch();
    }

}