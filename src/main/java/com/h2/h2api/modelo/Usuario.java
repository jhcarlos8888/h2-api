package com.h2.h2api.modelo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//Esta es una anotación para crear una entidad en este caso entidad Usuario
@Entity

//Esta es una anotacion para colocar esta clase como una tabla
@Table

//Esta anotación es para poder obtener los Getters y los Setters
@Data

//Esta anotación es para crear un constructor en la clase con todos los argumentos
@AllArgsConstructor

//Se crea un constructor sin todos los argumentos
@NoArgsConstructor

//en esta clase se modelará la entidad Usuario, es la representación de la entidad
public class Usuario {

    /***Se debe tener muy presente que las propiedades para cada atributo se
     * colocan en la parte de arriba según el atributo que se quiera a modificar
     */
    //Se crean los atributos necesarios que contiene un usuario

    @Id //Se crea una llave primaria para nuestra entidad

    //esta propiedad GeneratedValue lo que hará es que cada vez que se realice
    //un registro nuevo, autoincrementará la llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //esta propiedad lo que hará es que al momento de algún usuario realizar POST
    //obligará a que este campo tenga obligatoriamente algún dato
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String apellido;
    @Column(length = 16)
    private String telefono;
    @Column(nullable = false)
    private String direccion;

}
