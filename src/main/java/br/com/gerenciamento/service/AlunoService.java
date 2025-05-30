package br.com.gerenciamento.service;

import br.com.gerenciamento.model.Aluno;
import br.com.gerenciamento.repository.AlunoRepository;
import br.com.gerenciamento.enums.Curso;
import br.com.gerenciamento.enums.Status;
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

    public List<Aluno> buscarAlunosInativos() {
        return alunoRepository.findByStatusInativo();
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

    public List<Aluno> buscarPorNome(String nome) {
        return alunoRepository.findByNomeContainingIgnoreCase(nome);
    }

   public List<Aluno> buscarPorCursoEStatus(String nomeCurso, String status) {
       try {
           Curso cursoEnum = Curso.valueOf(nomeCurso.toUpperCase());
           Status statusEnum = Status.valueOf(status.toUpperCase());
           return alunoRepository.findByCursoAndStatus(cursoEnum, statusEnum);
       } catch (IllegalArgumentException e) {
           System.err.println("Erro ao converter curso ou status: " + e.getMessage());
           System.err.println("Valores recebidos - Curso: " + nomeCurso + ", Status: " + status);
           return List.of();
       }
   }
}