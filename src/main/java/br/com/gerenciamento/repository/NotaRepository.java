// src/main/java/br/com/gerenciamento/repository/NotaRepository.java
package br.com.gerenciamento.repository;

import br.com.gerenciamento.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaRepository extends JpaRepository<Nota, Long> {
}