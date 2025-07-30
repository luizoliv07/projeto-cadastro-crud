package com.luizdev.projeto_cadastro_crud.controller;

import com.luizdev.projeto_cadastro_crud.business.UsuarioService;
import com.luizdev.projeto_cadastro_crud.infrastructure.entities.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor

public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Void> salvarusuario(@RequestBody Usuario usuario) {
        usuarioService.saveUsuario(usuario);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Usuario> buscarUsuarioPorEmail(@RequestParam String email) {
        Usuario usuario = usuarioService.buscarUsuarioPorEmail(email);
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorEmail(email));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarUsuarioPorEmail(@RequestParam String email) {
        usuarioService.deletarUsuarioPorEmail(email);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarUsuarioPorId(
            @RequestParam Integer id, @RequestBody Usuario usuario) {
        usuarioService.atualizarUsuarioPorId(id, usuario);
        return ResponseEntity.ok().build();

    }


}
