package br.com.gerenciamento.repository;

import br.com.gerenciamento.model.Aluno;
import br.com.gerenciamento.enums.Curso;
import br.com.gerenciamento.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    List<Aluno> findByCursoAndStatus(Curso curso, Status status);

    @Query("SELECT a FROM Aluno a WHERE a.status = br.com.gerenciamento.enums.Status.ATIVO")
    List<Aluno> findByStatusAtivo();

    @Query("SELECT i FROM Aluno i WHERE i.status = br.com.gerenciamento.enums.Status.INATIVO")
    List<Aluno> findByStatusInativo();

    List<Aluno> findByNomeContainingIgnoreCase(String nome);
}