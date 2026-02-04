package com.duoc.restaurante.sistema.model;

public class Pedido implements Comparable<Pedido> {

    private final int id;
    private final String descripcion;
    private final PrioridadPedido prioridad;

    public Pedido(int id, String descripcion, PrioridadPedido prioridad) {
        this.id = id;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public PrioridadPedido getPrioridad() {
        return prioridad;
    }

    @Override
    public int compareTo(Pedido otro) {
        return this.prioridad.compareTo(otro.prioridad);
    }

    @Override
    public String toString() {
        return "[Pedido #" + id + ", " + descripcion + ", Prioridad: " + prioridad + "]";
    }
}
