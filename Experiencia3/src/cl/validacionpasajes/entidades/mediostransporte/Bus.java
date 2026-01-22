package cl.validacionpasajes.entidades.mediostransporte;

import cl.validacionpasajes.interfaces.*;

import java.util.ArrayList;
import java.util.List;

public class Bus extends VehiculoTransporte implements Cancelable, Rastreable, Desactivable {

    private List<String> historial = new ArrayList<>();

    public Bus(String codigo, ValidacionStrategy estrategia) {
        super(codigo, estrategia);
        historial.add("Bus creado : " + codigoVehiculo);
    }

    @Override
    public void mostrarIdentificacion() {
        System.out.println("[BUS]" + codigoVehiculo + (activo ? "(Activo)" : "(Inactivo)"));
        historial.add("Se mostro identificacion en el Bus " + codigoVehiculo);
    }

    @Override
    public boolean cancelar(String motivoCancelacion) {
        if(!activo){
            historial.add("Intento de cancelar Bus inactivo " + codigoVehiculo + " con el motivo " + motivoCancelacion);
            return false;
        }
        historial.add("Trayecto cancelado para el Bus " + codigoVehiculo + " motivo: " + motivoCancelacion);
        return true;
    }

    @Override
    public boolean desactivar(String motivo) {
        if(!activo){
            historial.add("Bus " + codigoVehiculo + " ya esta inactivo ");
            return false;
        }
        historial.add("Bus " + codigoVehiculo + "  Desactivado, motivo: " + motivo);
        return true;
    }

    @Override
    public boolean reactivar() {
        if(activo){
            historial.add("bUS " + codigoVehiculo + " ya esta activo");
            return false;
        }
        activo = false;
        historial.add("Bus " + codigoVehiculo + " reactivado");
        return true;
    }

    @Override
    public List<String> verHistorial() {
        return new ArrayList<>(historial);
    }
}
