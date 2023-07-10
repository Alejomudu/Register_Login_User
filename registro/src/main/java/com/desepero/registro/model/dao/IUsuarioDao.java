package com.desepero.registro.model.dao;

import com.desepero.registro.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioDao extends JpaRepository<Usuario, Long> {

    Usuario findByUsername(String username);
}
