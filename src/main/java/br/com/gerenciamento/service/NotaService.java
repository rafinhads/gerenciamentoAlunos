// src/main/java/br/com/gerenciamento/service/NotaService.java
package br.com.gerenciamento.service;

import br.com.gerenciamento.model.Nota;
import br.com.gerenciamento.model.Aluno;
import br.com.gerenciamento.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaService {

    @Autowired
    private NotaRepository notaRepository;

    public Nota salvarNota(Nota nota) {
        return notaRepository.save(nota);
    }

    public List<Nota> buscarNotasPorAluno(Aluno aluno) {
        return notaRepository.findByAluno(aluno);
    }
}