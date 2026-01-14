# Sistema de Validación de Pasajes - Transporte Público

Este proyecto consiste en el desarrollo incremental de un sistema de control y validación de pasajes para un entorno de transporte público simulado (Bus, Metro y Tranvía).

[cite_start]El objetivo principal es aplicar principios avanzados de **Programación Orientada a Objetos (POO)**, transitando desde conceptos básicos de herencia hasta la implementación de arquitecturas desacopladas mediante **Patrones de Diseño** e **Interfaces** [cite: 42-45].

## Objetivos del Proyecto

* [cite_start]**Modelar soluciones de software** basadas en problemas reales de transporte[cite: 43].
* [cite_start]**Aplicar Polimorfismo** (Sobrescritura y Sobrecarga) para generar comportamientos dinámicos según el tipo de usuario y vehículo[cite: 107].
* [cite_start]**Diseñar Jerarquías Robustas** utilizando Clases Abstractas para la reutilización de código y la definición de contratos [cite: 301-303].
* [cite_start]**Implementar Desacoplamiento** mediante Interfaces, siguiendo el principio de responsabilidad única[cite: 461].
* [cite_start]**Utilizar Patrones de Diseño** (Template Method y Strategy) para crear algoritmos flexibles y estandarizados[cite: 351, 597].

---

## Evolución del Proyecto

El desarrollo se estructura en tres etapas incrementales, aumentando la complejidad y calidad del diseño de software en cada iteración.

### Semana 1: Fundamentos de Polimorfismo
**Enfoque:** Flexibilidad básica y reutilización de nombres de métodos.

* **Características:**
    * [cite_start]Creación de una clase base `Usuario` con subclases (`Estudiante`, `Adulto`, `TerceraEdad`) [cite: 140-159].
    * [cite_start]Implementación de **Sobrescritura (@Override)** para aplicar tarifas diferenciadas en el método `validarPasaje()`[cite: 125].
    * [cite_start]Uso de **Sobrecarga** en la clase `Validador` para permitir validaciones con distintos parámetros (por ejemplo, validación estándar vs. validación con edad) [cite: 199-217].
* **Complejidad:** Baja. Se centra en entender que un mismo mensaje puede tener diferentes respuestas según el objeto receptor.

### Semana 2: Abstracción y Estandarización
**Enfoque:** Estructura jerárquica y algoritmos seguros.

* **Características:**
    * [cite_start]Introducción de la clase abstracta `VehiculoTransporte` para centralizar atributos comunes (`codigoVehiculo`) y forzar la implementación de métodos como `validarPasaje` [cite: 310-313].
    * Implementación del **Patrón Template Method** en la clase `ProcesoValidacion`. [cite_start]Esto define un algoritmo fijo (Conectar -> Validar -> Finalizar) donde las subclases solo pueden modificar el paso de validación, garantizando la integridad del proceso [cite: 371-377].
* **Complejidad:** Media. Se restringe la creación de objetos genéricos y se controlan los flujos de ejecución mediante métodos finales.

### Semana 3: Arquitectura Modular (Versión Final)
**Enfoque:** Desacoplamiento total, escalabilidad y principios SOLID.

* **Características:**
    * [cite_start]**Interfaces de Capacidad:** Se definen `Validable`, `Cancelable`, `Rastreable` y `Desactivable` para segregar responsabilidades y permitir que cada vehículo implemente solo lo necesario [cite: 526-587].
    * [cite_start]**Patrón Strategy:** Se encapsula la lógica de validación (QR, BIP, Sensor Magnético) en clases separadas (`ValidacionQR`, `ValidacionBIP`, etc.), permitiendo cambiar la estrategia de un vehículo en tiempo de ejecución sin modificar su código base [cite: 603-639].
    * [cite_start]**Gestor Centralizado:** Un `ControladorValidaciones` orquesta el sistema interactuando solo con las interfaces, sin conocer las clases concretas de los vehículos [cite: 784-806].
* **Complejidad:** Alta. Arquitectura lista para producción, flexible a cambios y extensibilidad (Open/Closed Principle).

---

## Tecnologías y Herramientas

* [cite_start]**Lenguaje:** Java (JDK 17 o superior recomendado)[cite: 78].
* [cite_start]**IDE:** IntelliJ IDEA[cite: 77].
* **Paradigma:** Programación Orientada a Objetos.

---

## Estructura del Proyecto (Versión Final)

[cite_start]La estructura de directorios para la entrega final es la siguiente [cite: 478-513]:

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
