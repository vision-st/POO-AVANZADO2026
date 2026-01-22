package cl.validacionpasajes.entidades;

public class TerceraEdad extends Usuario {
    @Override
    public void validarPasaje() {
        System.out.println("Tarifa tercera edad aplicada.");
    }
}