package com.example.app04.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.app04.model.Usuario;

@Service
public class UsuarioService {
    private List<Usuario> usuarios = new ArrayList<>();

    public void salvar(Usuario u) {
        usuarios.add(u);
    }

    public Usuario autenticar(String login, String senha) {
        for (Usuario u : usuarios) {
            if (u.getLogin().equals(login) && u.getSenha().equals(senha)) {
                return u;
            }
        }
        return null;
    }

    public boolean validar(String login, String senha) {
        return autenticar(login, senha) != null;
    }

}