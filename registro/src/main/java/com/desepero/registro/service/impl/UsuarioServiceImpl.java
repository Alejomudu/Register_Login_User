package com.desepero.registro.service.impl;

import com.desepero.registro.model.dao.IUsuarioDao;
import com.desepero.registro.model.entity.Usuario;
import com.desepero.registro.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private IUsuarioDao iUsuarioDao;

    @Override
    public Usuario findByUsername(String username) {
        return iUsuarioDao.findByUsername(username);
    }

    @Override
    public Usuario registrar(Usuario u) {

        u.setPassword(passwordEncoder.encode(u.getPassword()));

        return iUsuarioDao.save(u);
    }
}
