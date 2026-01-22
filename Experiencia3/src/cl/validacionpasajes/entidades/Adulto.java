package cl.validacionpasajes.entidades;

public class Adulto extends Usuario {
    @Override
    public void validarPasaje() {
        System.out.println("Tarifa adulto aplicada.");
    }
}