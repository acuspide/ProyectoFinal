package co.edu.uniquindio.poo;

import javax.swing.JOptionPane;

//clase conde se crea el parqueadero segun por los datos suministrados por el administrador del programa
public class Parqueadero {
    public int numeroPuestos;
    public String nombre;
    public int horizontal;
    public int vertical;
    public String[][] matrizpuestos;


    public Parqueadero(int numeroPuestos, String nombre) {
        this.numeroPuestos = numeroPuestos;
        this.nombre = nombre;
        
        //se crea metodo para inicializacion de matriz partiendo de un numero entero para dividirlo en factores y usarlos como filas y columnas de la matriz
        int[] factors = new int[2];
        for (int i = (int) Math.sqrt(numeroPuestos); i >= 1; i--) {
            if (numeroPuestos % i == 0) {
                factors[0] = i;
                factors[1] = numeroPuestos / i;
                break;
            }
        }
        this.horizontal=factors[1];
        this.vertical=factors[0];
        System.out.println("verticales: "+vertical+" horizontales: "+horizontal);
        
        matrizpuestos= new String [vertical][horizontal];//inicializacion de la matriz on filas y columnas
        
        
        //se llena la matriz con los caracteres 'D' y 'O' que representan disponible o ocuapado, llevando un registro propio de la clase de relaciondde puestos 
        for(int k=0; k <vertical; k ++){
            for(int l=0; l<horizontal; l++)
            {
                matrizpuestos[k][l]="D";
                // se declaran toddos los puestos del parqueadero en disponible porque se esta inicializando
            }   
        } 
    }

    //metodo que asigna un puesto diponible para un vehivulo que ingrese y retorna la posicion del puesto como un arreglo de enteros siendo la posicion 0=i y la pocicion 1=j
    public int[] asignarPuesto(){
        boolean label=false;
        int[] asignar=new int[2];
        for(int k=0; k <vertical; k ++){
            for(int l=0; l<horizontal; l++){
                if(label==false){
                    if(matrizpuestos[k][l]=="D"){
                        matrizpuestos[k][l]="O";
                        label=true;
                        asignar[0]=k;
                        asignar[1]=l;
                        System.out.println("Puesto asignado k ["+ k +"] l ["+ l +"]");
                    }        
                }
                       
            } 
        }
        //se define si hay puestos disponibles, si no los hay, retorna un arreglo de numeros negrativo que significaria que no hay puestos disponibles
        if(label==false){
            asignar[0]=-1;
            asignar[1]=-1;
            return asignar;
        }else{
            return asignar;
        }
    }


    public void librerarPuesto(int puesto[]){

        //metodo que cambia el estado de un puesto de disponible a ocupado
        if(matrizpuestos[puesto[0]][puesto[1]]=="O"){
            matrizpuestos[puesto[0]][puesto[1]]="D";
        }else{
            //si el puesto a liberar se encuentra en un estado incorrecto informa para corregir
            JOptionPane.showMessageDialog(null, "Lugar con formato errado ¡VERIFICAR!");
            System.out.print("\nLugar con formato errado ¡VERIFICAR!\n");
        }
    }

    public String verificarPuesto(int puesto[]){

        //metodo para verificar el estado de un puesto con 3 posibles estados disponibe, ocupado, o con un mal formato de busqueda
        //en la condicion se especifica el rango de valores que pueden tematr los valores de i y j sin salirse de los limites de la matriz para evitar errores
        if ((puesto[0]>=0) &&(puesto[0]<vertical) && (puesto[1]>=0) && (puesto[1]<horizontal)){
            if(matrizpuestos[puesto[0]][puesto[1]]=="O"){
                return "Puesto ocupado";
            }else{
                return "Puesto Libre";
            }            
            
        }else{
            return "Lugar con formato errado ¡VERIFICAR!";            
        }

    }

    //metodo que hace el conteo de puestos disponibles para llevar un contro en el menu
    public int numeroPuestos(){
        int puestosDisponibles=0;
        for(int k=0; k <vertical; k ++){
            for(int l=0; l<horizontal; l++){
                if(matrizpuestos[k][l]=="D"){
                    puestosDisponibles++;                              
                }
                       
            }
        }
        return puestosDisponibles;
    }


    public int getNumeroPuestos() {
        return numeroPuestos;
    }


    public String getNombre() {
        return nombre;
    }


    public int getHorizontal() {
        return horizontal;
    }


    public int getVertical() {
        return vertical;
    }
    
    }