package com.Aduanas.Aduana.controller;

import com.Aduanas.Aduana.model.TramiteFormularioSalidaOIngreso;
import com.Aduanas.Aduana.model.Usuario;
import com.Aduanas.Aduana.repository.TramiteRepository;
import com.Aduanas.Aduana.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class TramiteController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TramiteRepository tramiteRepository;

    @GetMapping("/tramite")
    public String mostratLoginTramite(Model model, Principal principal) {

        Usuario usuario = usuarioService.buscarPorNombre(principal.getName());

        TramiteFormularioSalidaOIngreso formulario = new TramiteFormularioSalidaOIngreso();
        formulario.setRun(formulario.getRun());
        formulario.setNombre(formulario.getNombre());
        formulario.setNacionalidad(formulario.getNacionalidad());
        formulario.setUsuario(usuario);

        model.addAttribute("tramiteFormularioSalidaOIngreso",formulario);
        return "tramite";
    }

    @PostMapping("/tramite")
    public String procesarFormulario(
            @ModelAttribute("tramiteFormularioSalidaOIngreso") TramiteFormularioSalidaOIngreso formulario){
        tramiteRepository.save(formulario);
        return "redirect:/tramite";
    }



}
