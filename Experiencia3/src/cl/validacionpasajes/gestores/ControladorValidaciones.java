package cl.validacionpasajes.gestores;

import cl.validacionpasajes.entidades.mediostransporte.Bus;
import cl.validacionpasajes.estrategias.ValidacionBIP;
import cl.validacionpasajes.interfaces.Cancelable;
import cl.validacionpasajes.interfaces.Desactivable;
import cl.validacionpasajes.interfaces.Rastreable;
import cl.validacionpasajes.interfaces.Validable;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.ArrayList;
import java.util.List;

public class ControladorValidaciones {

    private List<Validable> validables = new ArrayList<>();
    private List<Cancelable> cancelables = new ArrayList<>();
    private List<Rastreable> rastreables = new ArrayList<>();
    private List<Desactivable> desactibables = new ArrayList<>();

    public ControladorValidaciones() {
        Bus bus = new Bus("BUS01", new ValidacionBIP());
        validables.add(bus);
        cancelables.add(bus);
        rastreables.add(bus);
        desactibables.add(bus);
    }

    public void validarTodos(){
        for(Validable v : validables){
            v.validarPasaje();
        }
    }

    public void cancelarTodos(String motivo){
        for(Cancelable c: cancelables){
            c.cancelar(motivo);
        }
    }

    public void mostrarTodosHistoriales(){
        for(Rastreable r : rastreables){
            System.out.println("historial de " + r.getClass().getSimpleName());
            for(String evento : r.verHistorial()){
                System.out.println(evento);
            }
            System.out.println();
        }
    }
}
