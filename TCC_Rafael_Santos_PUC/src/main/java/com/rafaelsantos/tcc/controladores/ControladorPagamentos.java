package com.rafaelsantos.tcc.controladores;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.rafaelsantos.tcc.entidades.Aluno;
import com.rafaelsantos.tcc.servicos.ServicoAlunos;
import com.rafaelsantos.tcc.servicos.ServicoPagamentos;

@Controller
public class ControladorPagamentos {

private final ServicoPagamentos servicoPagamento;
private final ServicoAlunos servicoAluno;
    
    @Autowired
    public ControladorPagamentos(ServicoAlunos servicoAluno, ServicoPagamentos servicoPagamento) {
    	this.servicoAluno = servicoAluno;
    	this.servicoPagamento = servicoPagamento;
    }
    
    @GetMapping("/listaStatusPagamentoDosAlunos")
    public String listarAlunos(Model model) {
	List<Aluno> listaDeAlunos = this.servicoAluno.recuperarListadeAlunosdoBanco();
	model.addAttribute("listadeAlunos", listaDeAlunos);
	return "listagemstatuspagamentos";
    }
    
    @GetMapping("/listarPagamentosAluno") // Jogar para Controlador de Alunos
    public String ListarPags(Integer id, Model model) {
	Aluno alunoX = this.servicoAluno.recuperarAlunodoBanco(id);
		
	model.addAttribute("alunoX", alunoX);
    	
	return "listagempagamentosdealuno";
    }; 
    
    
    @GetMapping("/cadastrarPagamentoAluno")
    public String cadastrarPag(Integer id, Model model) throws InterruptedException {
	Aluno alunoX = this.servicoAluno.recuperarAlunodoBanco(id);
	this.servicoPagamento.cadastrarPagamentoNoBanco(alunoX);
	model.addAttribute("alunoX", alunoX);
	return "listagempagamentosdealuno";
    };
//    /listarPagamentosAluno(id=${aluno.id})
    
    
	
}
