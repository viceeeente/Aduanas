package com.Aduanas.Aduana.service;

import com.Aduanas.Aduana.model.Usuario;
import com.Aduanas.Aduana.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Optional<Usuario> autenticar(String nombre, String password) {
        Optional<Usuario> usuario = usuarioRepository.findByNombre(nombre);

        if (usuario.isPresent() && usuario.get().getPassword().equals(password)) {
            return usuario;
        }

        return Optional.empty();
    }
}