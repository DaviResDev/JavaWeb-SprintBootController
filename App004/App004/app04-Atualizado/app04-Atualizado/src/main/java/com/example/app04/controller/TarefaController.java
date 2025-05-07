package com.example.app04.controller;

import com.example.app04.model.Usuario;
import com.example.app04.service.TarefaService;
import com.example.app04.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TarefaController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TarefaService tarefaService;

    private Usuario usuarioLogado;

    @PostMapping("/loginTarefa")
    public String loginTarefa(@RequestParam String login, @RequestParam String senha) {
        usuarioLogado = usuarioService.autenticar(login, senha);
        if (usuarioLogado != null) {
            return "redirect:/tarefas";
        }
        return "redirect:/login";
    }

    @GetMapping("/tarefas")
    public ModelAndView tarefas() {
        ModelAndView mv = new ModelAndView("tarefas");
        mv.addObject("usuario", usuarioLogado);
        return mv;
    }

    @PostMapping("/adicionarTarefa")
    public String adicionarTarefa(@RequestParam String descricao) {
        tarefaService.adicionarTarefa(usuarioLogado, descricao);
        return "redirect:/tarefas";
    }

    @PostMapping("/concluirTarefa")
    public String concluirTarefa(@RequestParam int index, @RequestParam String dataConclusao) {
        tarefaService.concluirTarefa(usuarioLogado, index, dataConclusao);
        return "redirect:/tarefas";
    }
}