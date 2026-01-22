package cl.validacionpasajes.estrategias;

import cl.validacionpasajes.interfaces.ValidacionStrategy;

public class ValidacionBIP implements ValidacionStrategy {

    @Override
    public boolean validar() {
        System.out.println("Validanco con tarjeta bip");
        return true;
    }
}
