# Proyecto: Simulador de Restaurante Concurrente (Semana 5)

##  Descripción
Este proyecto es una evolución incremental que aplica conceptos de **programación concurrente avanzada** en Java[cite: 398, 399]. A diferencia de la versión básica, este simulador implementa mecanismos de **sincronización explícita** para gestionar el acceso a recursos compartidos, controlar la saturación del sistema y permitir el monitoreo de estado en tiempo real [cite: 373-375, 440].

##  Resultados de Aprendizaje
** Implementar hilos en una aplicación Java para ejecutar tareas simultáneas en entornos multitarea[cite: 36].
** Aplicar mecanismos de sincronización y control de consistencia para asegurar el funcionamiento correcto del software[cite: 37].

##  Herramientas de Sincronización Aplicadas
El sistema garantiza la integridad de los datos mediante el uso de:

| Herramienta | Propósito en el Sistema |
| :--- | :--- |
| **ReentrantLock** | Controla el acceso exclusivo a la cocina, permitiendo establecer una capacidad máxima y rechazar pedidos si el sistema está saturado[cite: 441, 458, 469]. |
| **volatile** | Asegura que los cambios en la bandera de control del monitor sean visibles instantáneamente para todos los hilos, permitiendo un cierre seguro[cite: 489, 495]. |
| **AtomicInteger** | Provee un contador de IDs de pedidos libre de condiciones de carrera, garantizando identificadores únicos en un entorno multihilo[cite: 124, 506, 519]. |
| **PriorityBlockingQueue** | Estructura que ordena automáticamente los pedidos según su nivel de urgencia (ALTA, MEDIA, BAJA) de forma segura para hilos[cite: 441, 457, 464]. |
| **ExecutorService** | Abstracción para gestionar el pool de hilos de los camareros, simplificando la creación y detención de tareas paralelas[cite: 229, 244, 559]. |

##  Estructura del Código (Semana 5)
La arquitectura del proyecto se ha modularizado para separar la lógica de negocio de la sincronización [cite: 413-417, 431-432]:

1.  **`CocinaSincronizada.java`**: Actúa como el recurso protegido que limita el procesamiento y organiza la prioridad[cite: 433, 442].
2.  **`MonitorEstado.java`**: Hilo observador que reporta periódicamente la carga de la cocina sin interferir en el flujo de trabajo[cite: 435, 475, 476].
3.  **`CamareroConcurrencia.java`**: Hilo productor que genera pedidos con tiempos de espera variables para simular un entorno real[cite: 434, 501, 503].
4.  **`Main.java`**: Orquestador principal que permite elegir entre la versión básica y la avanzada mediante un menú interactivo [cite: 529-531].

##  Instrucciones de Ejecución
1. **Configuración**: Asegúrate de tener instalado el JDK 17+ y el IDE IntelliJ IDEA[cite: 60].
2. **Menú Inicial**: Al ejecutar el programa, selecciona la **Opción 2** (Semana 5 - Sincronización avanzada)[cite: 535, 567].
3. **Simulación**: El sistema operará durante 15 segundos[cite: 546]. Observarás en consola cómo los pedidos de prioridad **ALTA** se anteponen a los de prioridad **BAJA**[cite: 594].
4. **Cierre**: El sistema realizará un cierre interrumpido y controlado de todos los hilos al finalizar el tiempo establecido[cite: 558, 597].

---
> **Nota de Diseño**: El uso de bloques `try-finally` con `lock.unlock()` es obligatorio en este proyecto para evitar bloqueos permanentes (deadlocks) en caso de excepciones[cite: 466, 693].