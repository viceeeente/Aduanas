package com.Aduanas.Aduana.controller;

import com.Aduanas.Aduana.model.Usuario;
import com.Aduanas.Aduana.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/bienvenida")
    public String mostratBienvenida(){
        return "bienvenida";
    }

    @GetMapping("/login")
    public String mostrarFormularioLogin() {
        return "login";
    }

    @GetMapping("/home")
    public String mostratHome(Model model) {
        return "home";
    }

    @PostMapping("/login")
    public String procesarLogin(@RequestParam String nombre,
                                @RequestParam String password,
                                Model model) {
        Optional<Usuario> usuario = usuarioService.autenticarLogin(nombre, password);

        if (usuario.isPresent()) {
            model.addAttribute("usuario", usuario.get());
            return "redirect:/home";
        } else {
            model.addAttribute("errorLogin", "Nombre o contraseña incorrectos");
            return "login";
        }
    }
}