// Archivo: Estudiante.java
package cl.validacionpasajes.entidades;

public class Estudiante extends Usuario {
    @Override
    public void validarPasaje() {
        System.out.println("Tarifa estudiante aplicada.");
    }
}

