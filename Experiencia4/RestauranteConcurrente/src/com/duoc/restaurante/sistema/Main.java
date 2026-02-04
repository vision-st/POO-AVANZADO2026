package com.duoc.restaurante.sistema;

import com.duoc.restaurante.sistema.workers.Camarero;
import com.duoc.restaurante.sistema.workers.Cocina;
import com.duoc.restaurante.sistema.service.GestorPedidos;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        GestorPedidos gestor = new GestorPedidos(10);

        ExecutorService executor = Executors.newFixedThreadPool(4);

        executor.execute(new Camarero(1, gestor));
        executor.execute(new Camarero(2, gestor));
        executor.execute(new Camarero(3, gestor));
        executor.execute(new Cocina(gestor));

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        executor.shutdownNow();

        try {
            executor.awaitTermination(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        System.out.println("[Main] Sistema finalizado.");
    }
}
