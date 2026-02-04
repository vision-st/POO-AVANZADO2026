package com.duoc.restaurante.sistema.workers;

import com.duoc.restaurante.sistema.model.Pedido;
import com.duoc.restaurante.sistema.service.GestorPedidos;

public class Cocina implements Runnable {

    private final GestorPedidos gestor;

    public Cocina(GestorPedidos gestor) {
        this.gestor = gestor;
    }

    @Override
    public void run() {

        while (!Thread.currentThread().isInterrupted()) {

            try {
                Pedido pedido = gestor.tomarPedido();

                if (pedido == null) continue;

                System.out.println("[Cocina] Preparando " + pedido);

                Thread.sleep(1500);

                System.out.println("[Cocina] Pedido completado " + pedido);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("[Cocina] Cerrando cocina.");
            }
        }
    }
}
