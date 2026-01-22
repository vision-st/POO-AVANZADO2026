package cl.validacionpasajes;

import cl.validacionpasajes.gestores.ControladorValidaciones;

public class Main {

    public static void main(String[]args){

        ControladorValidaciones controlador = new ControladorValidaciones();

        controlador.validarTodos();

        controlador.cancelarTodos("Falla tECNICA");

        controlador.mostrarTodosHistoriales();

    }

}
