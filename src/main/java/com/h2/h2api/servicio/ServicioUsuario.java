package com.h2.h2api.servicio;


import com.h2.h2api.modelo.Usuario;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface ServicioUsuario {

    //Se crea un método de tipo clase Usuario donde recibirá como parámetro un
    //objeto de tipo Usuario
    Usuario guardarUsuario(Usuario usuario);

    //la opción Optional se encarga de informar un error no pointer exeption
    //es un estandar que se maneja hoy en dia y recibe como parametro
    //el id del usuario, es decir el metodo debera retornar un objeto
    //usuario pero si no se devuelve o no se cumple, entonces se dispara
    //un error tipo exception
    Usuario obtenerUsuario(Long idUsuario);

    //Metodo para modificar un usuario, recibe como parametro un dato id y un objeto
    //usuario
    Usuario usuarioAModificar(Long id, Usuario usuarioModificar);

    //este metodo es para eliminar un usuario y recibira como parametro un id
    //retornara verdadero si se elimino o falso si paso algun error
    boolean eliminarUsuario(Long id);



}
