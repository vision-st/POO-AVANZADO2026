// Archivo: Main.java (Versión Semana 1)
package cl.validacionpasajes;

import cl.validacionpasajes.entidades.*;
import cl.validacionpasajes.validacion.ProcesoValidacion;
import cl.validacionpasajes.validacion.ValidacionBus;
import cl.validacionpasajes.validacion.ValidacionMetro;
import cl.validacionpasajes.validacion.ValidacionTranvia;


public class Main {
    public static void main(String[] args) {
        ProcesoValidacion[] procesos = {
                new ValidacionBus(),
                new ValidacionMetro(),
                new ValidacionTranvia()
        };

        for (ProcesoValidacion proceso : procesos){
            proceso.ejecutarProceso();
        }

    }
}
