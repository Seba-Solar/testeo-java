package com.testview.testeo.services;

import  com.testview.testeo.model.UsuarioModel;
import com.testview.testeo.repository.UsuarioRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    // Constructor con inyección de dependencia
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @PostConstruct
    public void init() {
        if (usuarioRepository != null) {
            UsuarioModel user = new UsuarioModel();
            user.setId(2L);
            user.setNombre("Sebastian");
            user.setCorreo("sebastian@gmail.com");
            usuarioRepository.save(user);
            System.out.println("User saved: " + user.getNombre());
        } else {
            System.out.println("usuarioRepository fallo");
        }
    }
}
