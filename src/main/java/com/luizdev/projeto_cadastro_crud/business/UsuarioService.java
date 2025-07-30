package com.luizdev.projeto_cadastro_crud.business;

import com.luizdev.projeto_cadastro_crud.infrastructure.entities.Usuario;
import com.luizdev.projeto_cadastro_crud.infrastructure.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service

public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void saveUsuario(Usuario usuario) {
        usuarioRepository.saveAndFlush(usuario);
    }

    public Usuario buscarUsuarioPorEmail(String email) {
        return usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o email: " + email));

    }

    public void deletarUsuarioPorEmail(String email) {
        usuarioRepository.deleteByEmail(email);
    }

    public void atualizarUsuarioPorId(Integer id, Usuario usuario) {
        Usuario  usuarioEntities = usuarioRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Usuário não encontrado com o ID: " + id));
        Usuario usuarioAtualizado = Usuario.builder()
                .email(usuario .getEmail() != null ?
                        usuario.getEmail() : usuarioEntities.getEmail())
                .nome(usuario.getNome() != null ?
                        usuario.getNome() : usuarioEntities.getNome())
                .id(usuarioEntities.getId())
                .build();

        usuarioRepository.saveAndFlush(usuarioAtualizado);
    }

}
