# Bank reto IAS

Componente para el banco andino para la gestion de pagos.

## Arquitectura

Este componente está diseñado siguiendo los principios de la **Arquitectura Hexagonal (Puertos y Adaptadores)**. El objetivo principal es aislar la lógica de negocio central de las dependencias 
externas (bases de datos, APIs de terceros, frameworks, etc.), facilitando el mantenimiento, las pruebas y la escalabilidad.

### Regla de Dependencia

* **Dominio (`domain`)**: No tiene dependencias externas ni conoce sobre infraestructura o frameworks.
* **Aplicación (`application`)**: Depende únicamente del dominio. Define los contratos (puertos) que la infraestructura debe implementar.
* **Infraestructura (`infrastructure`)**: Depende de las capas internas. Implementa los puertos de salida y expone los puertos de entrada. Dentro de esta tenemos los adaptadores para conexion a base de datps, en
este caso postgresql y las entradas a la aplicación por los entry points (end points)

```bash
```
