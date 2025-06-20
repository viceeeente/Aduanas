package com.Aduanas.Aduana.controller;

import com.Aduanas.Aduana.model.TramiteFormularioSalidaOIngreso;
import com.Aduanas.Aduana.model.Usuario;
import com.Aduanas.Aduana.model.Vehiculo;
import com.Aduanas.Aduana.repository.TramiteRepository;
import com.Aduanas.Aduana.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
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
    public String mostratLoginTramite(Model model, HttpSession session) {

        Usuario usuario = (Usuario) session.getAttribute("usuarioLogeado");
        System.out.println("Usuario en sesion: " + usuario);
        System.out.println("ID de sesion: " + session.getId());

        if(usuario == null){
            return "redirect:/login-tramite?error=acceso";
        }

        TramiteFormularioSalidaOIngreso formulario = new TramiteFormularioSalidaOIngreso();
        formulario.setRun(usuario.getRun());
        formulario.setNombre(usuario.getNombre());
        formulario.setClaveUnica(usuario.getClaveUnica());
        formulario.setNacionalidad(usuario.getNacionalidad());
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
