package br.com.gerenciamento.controller;

import br.com.gerenciamento.model.Aluno;
import br.com.gerenciamento.model.Nota;
import br.com.gerenciamento.service.AlunoService;
import br.com.gerenciamento.service.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private NotaService notaService;

    @GetMapping("/inserirAlunos")
    public ModelAndView insertAlunos(Aluno aluno) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Aluno/formAluno");
        modelAndView.addObject("aluno", new Aluno());
        return modelAndView;
    }

    @PostMapping("InsertAlunos")
    public ModelAndView inserirAluno(@Valid Aluno aluno, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if(bindingResult.hasErrors()) {
            modelAndView.setViewName("Aluno/formAluno");
            modelAndView.addObject("aluno");
        } else {
            modelAndView.setViewName("redirect:/alunos-adicionados");
            alunoService.salvar(aluno);
        }
        return modelAndView;
    }

    @GetMapping("alunos-adicionados")
    public ModelAndView listagemAlunos() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Aluno/listAlunos");
        modelAndView.addObject("alunosList", alunoService.buscarTodos());
        return modelAndView;
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Aluno/editar");
        Optional<Aluno> aluno = alunoService.buscarPorId(id);
        modelAndView.addObject("aluno", aluno.orElse(new Aluno()));
        return modelAndView;
    }

    @PostMapping("/editar")
    public ModelAndView editar(Aluno aluno) {
        ModelAndView modelAndView = new ModelAndView();
        alunoService.salvar(aluno);
        modelAndView.setViewName("redirect:/alunos-adicionados");
        return modelAndView;
    }

    @GetMapping("/remover/{id}")
    public String removerAluno(@PathVariable("id") Long id) {
        alunoService.removerPorId(id);
        return "redirect:/alunos-adicionados";
    }

    @GetMapping("filtro-alunos")
    public ModelAndView filtroAlunos() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Aluno/filtroAlunos");
        return modelAndView;
    }

    @GetMapping("alunos-ativos")
    public String listarAlunosAtivos(Model model) {
        List<Aluno> alunosAtivos = alunoService.buscarAlunosAtivos();
        model.addAttribute("alunosAtivos", alunosAtivos);
        return "Aluno/alunos-ativos";
    }

    @GetMapping("alunos-inativos")
    public ModelAndView listaAlunosInativos() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Aluno/alunos-inativos");
        modelAndView.addObject("alunosInativos", alunoService.buscarAlunosInativos());
        return modelAndView;
    }

    @PostMapping("/pesquisar-aluno")
    public ModelAndView pesquisarAluno(@RequestParam(required = false) String nome) {
        ModelAndView modelAndView = new ModelAndView();
        List<Aluno> listaAlunos;
        if(nome == null || nome.trim().isEmpty()) {
            listaAlunos = alunoService.buscarTodos();
        } else {
            listaAlunos = alunoService.buscarPorNome(nome);
        }
        modelAndView.addObject("ListaDeAlunos", listaAlunos);
        modelAndView.setViewName("Aluno/pesquisa-resultado");
        return modelAndView;
    }

    @GetMapping("/Aluno/alunos-lancamento")
    public String exibirLancamentoNota(@RequestParam("id") Long id, Model model) {
        model.addAttribute("alunoId", id);
        return "Aluno/alunos-lancamento";
    }

    @GetMapping("/aluno/{id}/notas")
    public String visualizarNotasAluno(@PathVariable("id") Long id, Model model) {
        Optional<Aluno> alunoOpt = alunoService.buscarPorId(id);
        if (alunoOpt.isPresent()) {
            Aluno aluno = alunoOpt.get();
            List<Nota> notas = notaService.buscarNotasPorAluno(aluno);
            model.addAttribute("aluno", aluno);
            model.addAttribute("notas", notas);
            return "Aluno/notas-aluno";
        } else {
            return "redirect:/alunos-ativos";
        }
    }
}