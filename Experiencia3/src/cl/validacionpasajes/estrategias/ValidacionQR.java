package cl.validacionpasajes.estrategias;

import cl.validacionpasajes.interfaces.ValidacionStrategy;

public class ValidacionQR implements ValidacionStrategy {

    @Override
    public boolean validar() {
        System.out.println("Validanco con codigo QR");
        return true;
    }
}
