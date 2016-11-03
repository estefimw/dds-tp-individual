# dds-tp-individual

Para poder persistir el modelo de dominio es necesario cambiar la  interfaz Imputable por una clase abstracta, de este modo, además, no repetimos la declaración de los atributos. Por otro lado, también es necesario modificar el tipo de dato de fecha en OrdenDeTrabajo por LocalDate para poder utilizarlo y es necesario convertirlo con LocalDateConverter.class para poder persistirlo.

Todas las relaciones que se encuentran en el modelo como @OneToMany(ordenDeTrabajo-imputables) y @OneToOne(ordenDeTrabajo-Cliente, UsoRepuesto-Repuesto, TrabajoOperario-Operario) se aplicaron en cascade para favorecer el mantenimiento y la consistencia.
