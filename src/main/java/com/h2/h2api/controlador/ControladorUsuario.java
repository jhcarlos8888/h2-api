package com.h2.h2api.controlador;


import com.h2.h2api.modelo.Usuario;
import com.h2.h2api.servicio.ServicioUsuario;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



/***La clase controlador llamara a la interface Serviciousuario*/

//Esta anotacion le va a indicar a SpringBoot que esta clase sera el controlador de la API que estamos
//desarrollando
@RestController

//esta annotation es para fijar la ruta de el controlador
@RequestMapping("/usuarios")

//Anotacion para crear un constructor de clase con todos sus argumentos
@RequiredArgsConstructor

public class ControladorUsuario {

    //Se crea un atributo de clase ServicioUsuario para poder manipular sus metodos y atributos
    private final ServicioUsuario servicioUsuario;

    //Ahora vamos a agregar unos verbos http ya que estamos creando un servicio REST
    @PostMapping
    //ResponseEntity Es una clase que provee Spring para poder manejar las respuestas de nuestros controladores, en este caso
    //es retorna un responseEntity
    //Se crea un metodo de clase ResponseEntity
    //es este caso se manda una peticion post que traera un recurso en este caso es un objeto de clase Usuario
    //Se recibe por parametro un objeto Usuario
    //Dentro de los parametros se debe de indicar que sera un objeto JSON de tipo Body, quien llegara
    //como parametro
    public ResponseEntity guardarUsuario(@RequestBody Usuario usuario){

            //Se retorna un objeto ResponseEntity el cual recibe como parametro una operacion de interfas
            //donde le pasaremos el objeto JSON usuario
            //Ademas se agrega un parametro que sera el codigo de respuesta al realizar una peticion
            //llamado HttpStatus y este a su vez llama una constante CREATED
            //el created generara un codigo de estado indicando la operacion realizada
            return new ResponseEntity(servicioUsuario.guardarUsuario(usuario), HttpStatus.CREATED);

    }




    //Se creara ahora un metodo tipo Get para obtener un usuario
    //Se crea una anotacion donde se le asignara un parametro de tipo id
    //para que la url tenga un dato id
    @GetMapping("/{id}")
    //Se crea un metodo que devuelte un RenponseEntity y se le pasara como parametro un id de un usuario
    //a este metodo debemos indicarle que tenemos un parametro en la URL esto se hace con una anotacion
    //que posee SpringBoot llamado @PathVariable y es el que recibira el nombre del parametro que se
    //le paso a la URL, entonces estamos ligando o asociando el parametro que tenemos dentro la URL
    //a el parametro que nos pide el metodo obtenerUsuario, es decir le pasaremos el id de GetMapping
    //al idUsuario del metodo
    public ResponseEntity obtenerUsuario(@PathVariable("id") Long idUsuario){

        //Se retorna un ResponseEntity que sera igual a la operacion dentro de la interfas servicioUsuario
        //que obtendra un usuario y se le pasara como parametro el id dentro de la URL,
        //si esto se cumple se mostrara un mensaje de estado OK
        return new ResponseEntity(servicioUsuario.obtenerUsuario(idUsuario),HttpStatus.OK);

    }


    //Metodo Put para modificar un registro, este tendra como parametro un Id
    @PutMapping("/{id}")

    //Se crea un metodo modificarUsuario donde se le pasara un id de usuario y un objeto JSON de clase Usuario
    public ResponseEntity modificarUsuario(@PathVariable("id") Long idUsuario, @RequestBody Usuario usuario){

        //Se retorna un ResponseEntity que sera igual a la operacion dentro de la interfas servicioUsuario
        //que obtendra un usuario y se le pasara como parametro el id dentro de la URL, ademas tambien se
        //le pasara un objeto JSON de clase Usuario
        //si esto se cumple se mostrara un mensaje de estado OK
        return new ResponseEntity(servicioUsuario.usuarioAModificar(idUsuario,usuario),HttpStatus.OK);

    }

    //Metodo Delete o verbo Delete para eliminar un usuario por medio de su ID
    @DeleteMapping("/{id}")
    //Se crea un metodo para eliminar un usuario se le pasa como parametro el Id
    //dentro de la URL
    public ResponseEntity eliminarUsuario(@PathVariable("id") Long idUsuario){

        boolean respuesta = servicioUsuario.eliminarUsuario(idUsuario);

        if(respuesta == true){

            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }


    }




}
