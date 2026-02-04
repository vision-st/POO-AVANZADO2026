package com.duoc.restaurante.sistema.service;

import com.duoc.restaurante.sistema.model.Pedido;

import java.util.concurrent.PriorityBlockingQueue;

public class GestorPedidos {

    private final PriorityBlockingQueue<Pedido> colaPedidos;

    public GestorPedidos(int capacidad) {
        this.colaPedidos = new PriorityBlockingQueue<>(capacidad);
    }

    public void agregarPedido(Pedido pedido) {
        colaPedidos.put(pedido);
    }

    public Pedido tomarPedido() {
        try {
            return colaPedidos.take(); // bloquea si no hay pedidos
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return null;
        }
    }
}
