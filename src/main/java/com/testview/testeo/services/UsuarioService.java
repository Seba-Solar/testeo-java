package com.testview.testeo.services;

import  com.testview.testeo.model.UsuarioModel;
import com.testview.testeo.repository.UsuarioRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    @Transactional
    public String registrarUsuario(String nombre,String correo,String password){
        try {
            UsuarioModel user = new UsuarioModel();
            user.setNombre(nombre);
            user.setCorreo(correo);
            user.setPassword(password);
            usuarioRepository.save(user);
            return  "Usuario registrado con exito";
        }catch (Exception e){
            return  "Error con el proceso de registro de usuario";
        }
    }

}
