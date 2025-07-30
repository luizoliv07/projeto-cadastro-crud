package com.luizdev.projeto_cadastro_crud.infrastructure.repository;

import com.luizdev.projeto_cadastro_crud.infrastructure.entities.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

     Optional<Usuario> findByEmail(String email);

     @Transactional
     public void deleteByEmail(String email);

}
