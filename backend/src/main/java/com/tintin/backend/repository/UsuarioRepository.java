package com.tintin.backend.repository;

import com.tintin.backend.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Métodos de busca customizados (opcional)
    Usuario findByEmail(String email);

    Usuario findByIdUsuario(long cd_usuario);
}
