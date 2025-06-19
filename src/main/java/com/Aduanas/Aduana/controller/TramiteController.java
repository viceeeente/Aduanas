package com.Aduanas.Aduana.controller;

import com.Aduanas.Aduana.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TramiteController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/tramite")
    public String mostratLoginTramite() {
        return "tramite";
    }
}
