// src/main/java/br/com/gerenciamento/repository/NotaRepository.java
package br.com.gerenciamento.repository;

import br.com.gerenciamento.model.Nota;
import br.com.gerenciamento.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotaRepository extends JpaRepository<Nota, Long> {
    List<Nota> findByAluno(Aluno aluno);
}