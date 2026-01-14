package cl.validacionpasajes;
import cl.validacionpasajes.Usuario;

public class TerceraEdad extends Usuario {
    @Override
    public void validarPasaje() {
        System.out.println("Tarifa tercera edad aplicada.");
    }
}