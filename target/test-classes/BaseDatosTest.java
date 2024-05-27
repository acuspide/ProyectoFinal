package co.edu.uniquindio.poo;

import java.lang.System.Logger;

public class BaseDatosTest {

    private static final Logger LOG = Logger.getLogger(BaseDatosTest.class.getName());
     /**
     * Prueba para verificar que los datos completos propietario
     */
    @Test
    public void agregarPropietario() {
        LOG.info ("Inicio de test agregarPropietario");

        Propietario propietario= new Propietario("camilo", "carvajal", "1024582", "Propietario", 0);
        BaseDatos base=new BaseDatos();
        base.propietarios.add(propietario);
        assertTrue(base.getPropietarios().contains(propietario));

        LOG.info ("Fin de test agregarPropietario");
    }
    
}
