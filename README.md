# Sistema de Gestión de Pedidos para Estudio Fotográfico

## 1. Descripción general del proyecto
Aplicación web desarrollada con Java y Spring Boot orientada a digitalizar y centralizar la administración de órdenes de trabajo de un estudio fotográfico. El sistema permite registrar pedidos de clientes, diferenciar categorías de servicio (por ejemplo, sesiones estándar frente a servicios especiales o de evento), dar seguimiento en tiempo real a cada etapa del flujo de producción (recepción, edición, preparación de impresión y entrega) y generar comprobantes digitales claros con el desglose de conceptos, anticipos y saldos pendientes. Con ello se eliminan errores de captura manual, retrasos en entregas y descontrol en el estado de cada orden.

---

## 2. Integrantes del equipo
* **Valeria Becerra Salazar** 

---

## 3. Tabla de requerimientos (Primeros 5 requerimientos)

| ID | Requerimiento | Tipo | Descripción | Prioridad |
| :--- | :--- | :--- | :--- | :--- |
| **RF-01** | Registro y gestión de pedidos | Funcional | Permitir crear, consultar, actualizar y cancelar órdenes de servicio asociando datos del cliente, tipo de paquete, fecha de entrega y monto total/anticipo. | Alta |
| **RF-02** | Seguimiento de etapas de producción | Funcional | Controlar y actualizar el estado operativo de cada pedido a lo largo de su ciclo de vida (`Recibido`, `En edición`, `En diseño/impresión`, `Listo para entrega`, `Entregado`). | Alta |
| **RF-03** | Clasificación por tipo de pedido | Funcional | Distinguir entre órdenes estándar y órdenes especiales/urgentes para aplicar reglas de prioridad, tiempos estimados y filtrado operativo. | Alta |
| **RF-04** | Generación de comprobante / recibo del cliente | Funcional | Emitir un resumen estructurado del pedido (folio, servicios contratados, estado actual, anticipo y saldo restante) listo para compartir con el cliente. | Media |
| **RF-05** | Consulta y filtrado de órdenes | Funcional | Permitir buscar pedidos por folio, nombre del cliente, fecha de entrega o estado de producción para agilizar la atención en mostrador. | Media |

---

## 4. Funcionalidades a resolver con paquetes / starters de Spring Boot

* **API REST y controladores web (`spring-boot-starter-web`):** Exposición de endpoints HTTP (`@RestController`) para registrar pedidos, cambiar estados de producción y consultar recibos en formato JSON sobre servidor embebido Tomcat.
* **Persistencia y consultas en base de datos (`spring-boot-starter-data-jpa` + driver JDBC):** Mapeo objeto-relacional (ORM) de entidades como `Cliente`, `Pedido` y `DetalleServicio`, utilizando interfaces `JpaRepository` para búsquedas filtradas por estado, folio o fecha sin escribir SQL repetitivo.
* **Validación de reglas de negocio (`spring-boot-starter-validation`):** Verificación automática de datos de entrada en los pedidos (campos obligatorios del cliente, fechas de entrega válidas, montos y anticipos no negativos) mediante anotaciones como `@NotBlank`, `@NotNull` y `@PositiveOrZero`.
* **Autenticación y control de roles (`spring-boot-starter-security`):** Protección de rutas y asignación de permisos diferenciados para el personal del estudio (por ejemplo, recepción/mostrador vs. área de edición o administración).
* **Bitácora de auditoría y monitoreo (`spring-boot-starter-logging` / `spring-boot-starter-actuator`):** Registro trazable de cambios de estado en los pedidos y supervisión de la disponibilidad del sistema (`/actuator/health`).
* **Documentación interactiva de endpoints (`springdoc-openapi-starter-webmvc-ui`):** Generación automática de interfaz Swagger UI para probar y documentar las operaciones de gestión de pedidos.
