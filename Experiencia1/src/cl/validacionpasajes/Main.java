// Archivo: Main.java (Versión Semana 1)
package cl.validacionpasajes;

public class Main {
    public static void main(String[] args) {
        // Prueba Polimorfismo (Sobrescritura)
        Usuario[] usuarios = { new Estudiante(), new Adulto(), new TerceraEdad() };
        for (Usuario u : usuarios) {
            u.validarPasaje();
        }

        // Prueba Sobrecarga
        Validador validador = new Validador();
        System.out.println("\n=== Validación con sobrecarga ===");
        validador.validarPasaje();
        validador.validarPasaje("Estudiante");
        validador.validarPasaje("Tercera Edad", 65);
    }
}
