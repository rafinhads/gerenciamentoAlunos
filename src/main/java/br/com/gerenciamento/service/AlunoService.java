// src/main/java/br/com/gerenciamento/service/AlunoService.java
package br.com.gerenciamento.service;

import br.com.gerenciamento.model.Aluno;
import br.com.gerenciamento.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> buscarAlunosAtivos() {
        return alunoRepository.findByStatusAtivo();
    }

    public void salvar(Aluno aluno) {
        alunoRepository.save(aluno);
    }

    public List<Aluno> buscarTodos() {
        return alunoRepository.findAll();
    }

    public Optional<Aluno> buscarPorId(Long id) {
        return alunoRepository.findById(id);
    }

    public void removerPorId(Long id) {
        alunoRepository.deleteById(id);
    }

    public List<Aluno> buscarAlunosInativos() {
        return alunoRepository.findByStatusInativo();
    }

    public List<Aluno> buscarPorNome(String nome) {
        return alunoRepository.findByNomeContainingIgnoreCase(nome);
    }
}