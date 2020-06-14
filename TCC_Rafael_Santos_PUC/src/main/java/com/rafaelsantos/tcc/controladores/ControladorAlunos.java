package com.rafaelsantos.tcc.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.rafaelsantos.tcc.entidades.Aluno;
import com.rafaelsantos.tcc.servicos.ServicoAlunos;


@Controller
public class ControladorAlunos {


    private final ServicoAlunos servicoAluno;
    
    @Autowired
    public ControladorAlunos(ServicoAlunos servicoAluno) {
	this.servicoAluno = servicoAluno;
    }
    
    @GetMapping("/areaDoEmpregado")
    public String axibirAreaEmpregados(Model model) {
	return "menuAreaEmpregados";
    }  
    
    @GetMapping("/FormulariodeCadastroAluno")
    public String ExibirFormulario(Model model) {
	model.addAttribute("aluno", new Aluno());
	return "alunocadastro";
    }
    
    @PostMapping("/cadastrarAluno")
    public String cadastrar(@ModelAttribute Aluno aluno) {
	this.servicoAluno.cadastrarAlunoNoBanco(aluno);
	return "redirect:/listaDeAlunosMatriculados";
    }
    
    @GetMapping("/listaDeAlunosMatriculados")
    public String listarAlunos(Model model) {
	List<Aluno> listaDeAlunos = this.servicoAluno.recuperarListadeAlunosdoBanco();
	model.addAttribute("listadeAlunos", listaDeAlunos);
	return "listagemdealunos";
    }
    
    
    @GetMapping("/areaDoGerente")
    public String ExibirAreaGerente(Model model) {
	model.addAttribute("aluno", new Aluno());
	return "areadogerente";
    }
    
    @GetMapping("/areaDaRecepcionista")
    public String ExibirAreaRecepcionista(Model model) {
	model.addAttribute("aluno", new Aluno());
	return "arearecepcionista";
    }
    
    
}
