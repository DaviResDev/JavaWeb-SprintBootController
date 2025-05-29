
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import seu.pacote.model.Filme;
import seu.pacote.model.Usuario;
import seu.pacote.service.FilmeService;
import seu.pacote.service.UsuarioService;

@Controller
public class FilmeController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private FilmeService filmeService;

    @GetMapping("/")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String logar(@RequestParam String email, @RequestParam String senha, HttpSession session, Model model) {
        Usuario u = usuarioService.autenticar(email, senha);
        if (u != null) {
            session.setAttribute("usuario", u);
            return "redirect:/principal";
        } else {
            model.addAttribute("erro", "Credenciais inválidas");
            return "login";
        }
    }

    @GetMapping("/principal")
    public String principal(HttpSession session, Model model) {
        Usuario u = (Usuario) session.getAttribute("usuario");
        model.addAttribute("paraAssistir", filmeService.listarParaAssistir(u.getId()));
        model.addAttribute("assistidos", filmeService.listarAssistidos(u.getId()));
        return "principal";
    }

    @PostMapping("/filme")
    public String salvarFilme(Filme filme, HttpSession session) {
        Usuario u = (Usuario) session.getAttribute("usuario");
        filme.setUsuario(u);
        filme.setAssistido(false);
        filmeService.salvar(filme);
        return "redirect:/principal";
    }

    @PostMapping("/assistir/{id}")
    public String marcarComoAssistido(@PathVariable Long id) {
        Filme f = filmeService.repo.findById(id).get();
        filmeService.marcarComoAssistido(f);
        return "redirect:/principal";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
