package com.h2.h2api.servicio;

import com.h2.h2api.modelo.Usuario;
import com.h2.h2api.repositorio.RepositorioUsuario;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

//Se crea una anotacion que sera un estereotipo para decirle a esta clase que sera un servicio
//esto hara que se reconozca en SpringBoot, estas anotaciones pertenecen al modulo lombok
//que trae SpringBoot
@Service
@AllArgsConstructor

public class ServicioUsuarioImpl implements ServicioUsuario {

    //Se declara un atributo de tipo interface
    //Ahora para que funcione este atributo de clase interfas
    //se debe de inicializar en un constructor
    //eso se puede realizar manualmente o con una anotacion que trae Springboot
    //llamada AllArgsConstructor, esta me creara un constructor
    //con lo necesario para poder manejar atributos de clase
    private final RepositorioUsuario repositoriousuario;



    //se crea un metodo guardar usuario que retorna un usuario al llamar la interfas
    //repositoriosuario, que a su vez llama al metodo save de la clase JpaRepository,
    //quien es la que tiene los metodos necesarios para interactuar con la base de datos
    //esta clase la trae como ta l
    @Override
    public Usuario guardarUsuario(Usuario usuario) {

        return repositoriousuario.save(usuario);
    }

    @Override
    public Usuario obtenerUsuario(Long idUsuario) {

        return repositoriousuario.findById(idUsuario).orElseThrow(() -> {throw new RuntimeException();});
    }

    @Override
    public Usuario usuarioAModificar(Long id, Usuario usuarioModificar) {

        //Creamos un objeto tipo Usuario y sera igual a una operacion del repositorio usuario
        //donde buscamos el usuario por id
        Usuario usuarioBuscado = repositoriousuario.findById(id).get();

        //luego a ese objeto le asignaremos una direccion que traera el objeto usuarioModificar
        //Ese objeto ya traera la informacion modificada y en este caso solo modificaremos
        //la direccion
        usuarioBuscado.setDireccion(usuarioModificar.getDireccion());
        usuarioBuscado.setTelefono(usuarioModificar.getTelefono());

        //retornamos guardando la modificacion, es decir guardaremos entonces el nuevo objeto
        return repositoriousuario.save(usuarioBuscado);
    }


    //Metodo para eliminar un usuario
    @Override
    public boolean eliminarUsuario(Long id) {

        try{
            //Se llama un metodo del jpa que elimina un registro por medio del id
            repositoriousuario.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }


    }


}
