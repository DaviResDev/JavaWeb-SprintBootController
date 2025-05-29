package seu.pacote.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seu.pacote.model.Filme;
import seu.pacote.repository.FilmeRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class FilmeService {

    @Autowired
    public FilmeRepository repo;

    public void salvar(Filme f) {
        repo.save(f);
    }

    public List<Filme> listarParaAssistir(Long usuarioId) {
        return repo.findByUsuarioIdAndAssistido(usuarioId, false);
    }

    public List<Filme> listarAssistidos(Long usuarioId) {
        return repo.findByUsuarioIdAndAssistido(usuarioId, true);
    }

    public void marcarComoAssistido(Filme f) {
        f.setAssistido(true);
        f.setDataAssistido(LocalDate.now());
        repo.save(f);
    }
}
