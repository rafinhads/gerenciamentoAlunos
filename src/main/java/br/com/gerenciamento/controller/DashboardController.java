package br.com.gerenciamento.controller;

import br.com.gerenciamento.service.AlunoService;
import br.com.gerenciamento.service.NotaService;
import br.com.gerenciamento.enums.Curso;
import br.com.gerenciamento.model.Aluno;
import br.com.gerenciamento.model.Nota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class DashboardController {

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private NotaService notaService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        int ativos = alunoService.buscarAlunosAtivos().size();
        int inativos = alunoService.buscarAlunosInativos().size();

        // Médias por curso
        Map<String, Double> mediasPorCurso = new LinkedHashMap<>();
        for (Curso curso : Curso.values()) {
            List<Aluno> alunosCurso = alunoService.buscarTodos().stream()
                .filter(a -> a.getCurso() == curso)
                .collect(Collectors.toList());
            List<Nota> notasCurso = new ArrayList<>();
            for (Aluno aluno : alunosCurso) {
                notasCurso.addAll(notaService.buscarNotasPorAluno(aluno));
            }
            double media = notasCurso.stream()
                .mapToDouble(Nota::getValor)
                .average()
                .orElse(0.0);
            mediasPorCurso.put(curso.name(), media);
        }

        model.addAttribute("ativos", ativos);
        model.addAttribute("inativos", inativos);
        model.addAttribute("mediasPorCurso", mediasPorCurso);
        return "Dashboard/dashboard";
    }
}