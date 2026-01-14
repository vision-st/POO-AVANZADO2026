# Sistema de Validación de Pasajes - Transporte Público

Este proyecto consiste en el desarrollo incremental de un sistema de control y validación de pasajes para un entorno de transporte público simulado (Bus, Metro y Tranvía).

El objetivo principal es aplicar principios avanzados de **Programación Orientada a Objetos (POO)**, transitando desde conceptos básicos de herencia hasta la implementación de arquitecturas desacopladas mediante **Patrones de Diseño** e **Interfaces**.

## Objetivos del Proyecto

* **Modelar soluciones de software** basadas en problemas reales de transporte.
* **Aplicar Polimorfismo** (Sobrescritura y Sobrecarga) para generar comportamientos dinámicos según el tipo de usuario y vehículo.
* **Diseñar Jerarquías Robustas** utilizando Clases Abstractas para la reutilización de código y la definición de contratos.
* **Implementar Desacoplamiento** mediante Interfaces, siguiendo el principio de responsabilidad única.
* **Utilizar Patrones de Diseño** (Template Method y Strategy) para crear algoritmos flexibles y estandarizados.

---

## Evolución del Proyecto

El desarrollo se estructura en tres etapas incrementales, aumentando la complejidad y calidad del diseño de software en cada iteración.

### Semana 1: Fundamentos de Polimorfismo
**Enfoque:** Flexibilidad básica y reutilización de nombres de métodos.

* **Características:**
    * Creación de una clase base `Usuario` con subclases (`Estudiante`, `Adulto`, `TerceraEdad`).
    * Implementación de **Sobrescritura (@Override)** para aplicar tarifas diferenciadas en el método `validarPasaje()`.
    * Uso de **Sobrecarga** en la clase `Validador` para permitir validaciones con distintos parámetros (por ejemplo, validación estándar vs. validación con edad).
* **Complejidad:** Baja. Se centra en entender que un mismo mensaje puede tener diferentes respuestas según el objeto receptor.

### Semana 2: Abstracción y Estandarización
**Enfoque:** Estructura jerárquica y algoritmos seguros.

* **Características:**
    * Introducción de la clase abstracta `VehiculoTransporte` para centralizar atributos comunes (`codigoVehiculo`) y forzar la implementación de métodos como `validarPasaje`.
    * Implementación del **Patrón Template Method** en la clase `ProcesoValidacion`. Esto define un algoritmo fijo (Conectar -> Validar -> Finalizar) donde las subclases solo pueden modificar el paso de validación, garantizando la integridad del proceso.
* **Complejidad:** Media. Se restringe la creación de objetos genéricos y se controlan los flujos de ejecución mediante métodos finales.

### Semana 3: Arquitectura Modular (Versión Final)
**Enfoque:** Desacoplamiento total, escalabilidad y principios SOLID.

* **Características:**
    * **Interfaces de Capacidad:** Se definen `Validable`, `Cancelable`, `Rastreable` y `Desactivable` para segregar responsabilidades y permitir que cada vehículo implemente solo lo necesario.
    * **Patrón Strategy:** Se encapsula la lógica de validación (QR, BIP, Sensor Magnético) en clases separadas (`ValidacionQR`, `ValidacionBIP`, etc.), permitiendo cambiar la estrategia de un vehículo en tiempo de ejecución sin modificar su código base.
    * **Gestor Centralizado:** Un `ControladorValidaciones` orquesta el sistema interactuando solo con las interfaces, sin conocer las clases concretas de los vehículos.
* **Complejidad:** Alta. Arquitectura lista para producción, flexible a cambios y extensibilidad (Open/Closed Principle).

---

## Tecnologías y Herramientas

* **Lenguaje:** Java (JDK 17 o superior recomendado).
* **IDE:** IntelliJ IDEA.
* **Paradigma:** Programación Orientada a Objetos.

---

## Estructura del Proyecto (Versión Final)

La estructura de directorios para la entrega final es la siguiente:

```text
src/main/java/cl/validacionpasajes/
├── estrategias/            # Patrón Strategy (Algoritmos de validación)
│   ├── ValidacionStrategy.java
│   ├── ValidacionQR.java
│   ├── ValidacionBIP.java
│   └── ValidacionSensorMagnetico.java
├── gestores/               # Lógica de control
│   └── ControladorValidaciones.java
├── interfaces/             # Capacidades desacopladas
│   ├── Validable.java
│   ├── Cancelable.java
│   ├── Rastreable.java
│   └── Desactivable.java
├── Bus.java                # Implementación concreta
├── Metro.java              # Implementación concreta
├── Tranvia.java            # Implementación concreta
├── VehiculoTransporte.java # Clase Abstracta Base
└── Main.java               # Punto de entrada y simulación