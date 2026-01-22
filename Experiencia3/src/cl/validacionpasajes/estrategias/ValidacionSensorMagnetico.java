package cl.validacionpasajes.estrategias;

import cl.validacionpasajes.interfaces.ValidacionStrategy;

public class ValidacionSensorMagnetico implements ValidacionStrategy {

    @Override
    public boolean validar() {
        System.out.println("Validanco con sensor magnetico");
        return true;
    }
}
