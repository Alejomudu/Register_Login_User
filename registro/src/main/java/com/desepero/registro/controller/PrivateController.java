package com.desepero.registro.controller;

import com.desepero.registro.model.entity.Usuario;
import com.desepero.registro.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/private")
public class PrivateController {

    @Autowired
    private IUsuarioService iUsuarioService;

    @GetMapping("/index")
    public String index(Authentication auth, HttpSession session){

        String username = auth.getName();

        if(session.getAttribute("usuario") == null){
            Usuario usuario = iUsuarioService.findByUsername(username);
            usuario.setPassword(null);
            session.setAttribute("usuario", usuario);
        }

        return "index";
    }
}
