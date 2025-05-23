// src/main/java/br/com/gerenciamento/controller/NotaController.java
package br.com.gerenciamento.controller;

import br.com.gerenciamento.model.Nota;
import br.com.gerenciamento.service.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notas")
public class NotaController {

    @Autowired
    private NotaService notaService;

    @PostMapping
    public Nota adicionarNota(@RequestBody Nota nota) {
        return notaService.salvarNota(nota);
    }
}