package com.h2.h2api.repositorio;

import com.h2.h2api.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


//Esta clase sera quien realizara la logica mas profunda que tiene JPA
//JPA trae unos metodos implicitamente, entonces esta clase al ser una interfas
//implementara todos los metodos de JPA, entonces para implementar todos esos metodos
//se debe de ir a otra clase que implemente todos estos metodos y poder
//utilizarlos, que seria entonces ServicioUsuarioImpl
public interface RepositorioUsuario extends JpaRepository<Usuario,Long> {
}
