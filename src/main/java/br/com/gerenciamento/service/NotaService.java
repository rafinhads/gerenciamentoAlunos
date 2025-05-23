// src/main/java/br/com/gerenciamento/service/NotaService.java
package br.com.gerenciamento.service;

import br.com.gerenciamento.model.Nota;
import br.com.gerenciamento.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotaService {

    @Autowired
    private NotaRepository notaRepository;

    public Nota salvarNota(Nota nota) {
        return notaRepository.save(nota);
    }
}