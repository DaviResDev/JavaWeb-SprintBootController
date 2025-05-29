package seu.pacote.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seu.pacote.model.Usuario;
import seu.pacote.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repo;

    public void salvar(Usuario u) {
        repo.save(u);
    }

    public Usuario autenticar(String email, String senha) {
        return repo.findByEmailAndSenha(email, senha);
    }
}
