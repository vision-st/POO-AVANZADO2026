package cl.validacionpasajes.validacion;

public abstract class ProcesoValidacion {

    // Metodo plantilla (lo vamos a dejar final)
    public final void ejecutarProceso(){
        conectar();
        validar();
        finalizar();
    }

    private void conectar(){
        System.out.println("Conectando a la base de datos de validacion...");
    }

    protected abstract void validar();

    private void finalizar(){
        System.out.println("Cerrando la conectando a la base de datos de validacion...");
    }
}
