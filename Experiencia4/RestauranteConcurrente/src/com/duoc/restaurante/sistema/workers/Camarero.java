package com.duoc.restaurante.sistema.workers;

import com.duoc.restaurante.sistema.model.Pedido;
import com.duoc.restaurante.sistema.model.PrioridadPedido;
import com.duoc.restaurante.sistema.service.GestorPedidos;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Camarero implements Runnable {

    private static final AtomicInteger contadorGlobal = new AtomicInteger(1);

    private final int idCamarero;
    private final GestorPedidos gestor;
    private final Random random = new Random();
    private final String[] platos = {"Pizza", "Sopa", "Ensalada", "Lasaña", "Postre"};
    private final String nombre;

    public Camarero(int idCamarero, GestorPedidos gestor) {
        this.idCamarero = idCamarero;
        this.gestor = gestor;

        switch (idCamarero) {
            case 1 -> nombre = "Carlos";
            case 2 -> nombre = "Laura";
            case 3 -> nombre = "Javiera";
            default -> nombre = "Camarero " + idCamarero;
        }
    }

    @Override
    public void run() {

        generarYAgregarPedido();

        for (int i = 1; i < 5; i++) {
            try {
                int delay = 1000 + random.nextInt(1000);
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("[Camarero " + nombre + "] Interrumpido.");
                return;
            }

            generarYAgregarPedido();
        }
    }

    private void generarYAgregarPedido() {

        int idPedido = contadorGlobal.getAndIncrement();

        String plato = platos[random.nextInt(platos.length)];
        PrioridadPedido prioridad = generarPrioridad();

        Pedido pedido = new Pedido(idPedido, plato, prioridad);

        System.out.println("[Camarero " + nombre + "] Generando " + pedido);

        gestor.agregarPedido(pedido);
    }

    private PrioridadPedido generarPrioridad() {

        int valor = (int) (Math.random() * 3);

        return switch (valor) {
            case 0 -> PrioridadPedido.ALTA;
            case 1 -> PrioridadPedido.MEDIA;
            default -> PrioridadPedido.BAJA;
        };
    }
}
