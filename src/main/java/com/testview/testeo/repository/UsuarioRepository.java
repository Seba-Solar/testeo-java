package com.testview.testeo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.testview.testeo.model.UsuarioModel;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
}
