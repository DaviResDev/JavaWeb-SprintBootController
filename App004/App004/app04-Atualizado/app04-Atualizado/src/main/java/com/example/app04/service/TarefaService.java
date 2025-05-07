package com.example.app04.service;

import com.example.app04.model.Tarefa;
import com.example.app04.model.Usuario;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TarefaService {

    public void adicionarTarefa(Usuario usuario, String descricao) {
        if (usuario != null && descricao != null && !descricao.isBlank()) {
            Tarefa novaTarefa = new Tarefa(descricao, LocalDate.now().toString());
            usuario.adicionarTarefa(novaTarefa);
        }
    }

    public void concluirTarefa(Usuario usuario, int index, String dataConclusao) {
        if (usuario != null && index >= 0 && index < usuario.getTarefas().size()) {
            Tarefa tarefa = usuario.getTarefas().get(index);
            tarefa.setConcluida(true);
            tarefa.setDataConclusao(dataConclusao);
        }
    }

    public List<Tarefa> listarTarefas(Usuario usuario) {
        return usuario != null ? usuario.getTarefas() : List.of();
    }
}