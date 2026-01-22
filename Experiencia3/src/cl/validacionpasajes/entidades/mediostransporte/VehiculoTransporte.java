package cl.validacionpasajes.entidades.mediostransporte;

import cl.validacionpasajes.interfaces.Validable;
import cl.validacionpasajes.interfaces.ValidacionStrategy;

public abstract class VehiculoTransporte implements Validable {

    protected String codigoVehiculo;
    protected boolean activo = true;
    protected ValidacionStrategy estrategia;

    public VehiculoTransporte(String codigo, ValidacionStrategy estrategia){
        this.codigoVehiculo = codigo;
        this.estrategia = estrategia;
    }

    @Override
    public boolean validarPasaje(){
        if(!activo){
            System.out.println("[ERROR] " + codigoVehiculo + "esta inactivo, no se puede validar");
            return false;
        }
        boolean exitoso = estrategia.validar();
        return exitoso;
    }

    public abstract void mostrarIdentificacion();

}
