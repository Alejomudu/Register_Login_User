package com.desepero.registro.service;

import com.desepero.registro.model.entity.Usuario;

public interface IUsuarioService {

    Usuario findByUsername(String username);

    Usuario registrar(Usuario u);
}
