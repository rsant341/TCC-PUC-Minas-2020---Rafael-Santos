package com.rafaelsantos.tcc.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Aluno {

	
    @Id
    @GeneratedValue
    private int id;   
    
    private String nome;
    private String cpf; 
    private String rg; 
    private String endereco;
    private String tipoPlano;
    private int matricula;
    private String statusDeTodosPagamentos;
    


	@OneToMany(mappedBy = "aluno",fetch = FetchType.EAGER,cascade = CascadeType.ALL)   
    private List<Pagamento> listaPagamentos = new ArrayList<>();
    
    public Aluno(){}
    
    public Aluno(int numero_matricula,String nome_aluno,String cpf,String rg,String endereco, String tipoPlano) {
	 this.matricula = numero_matricula;
	 this.nome = nome_aluno;
	 this.cpf = cpf;
	 this.rg = rg;
	 this.endereco = endereco;
	 this.tipoPlano = tipoPlano;
	 this.statusDeTodosPagamentos = ""; 
    }
    

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTipoPlano() {
		return tipoPlano;
	}

	public void setTipoPlano(String tipoPlano) {
		this.tipoPlano = tipoPlano;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

    public List<Pagamento> getListaPagamentos() {
		return this.listaPagamentos;
	}

	public void addPagamento(Pagamento pagamento) {
		this.listaPagamentos.add(pagamento);
		estaoTodosPagamentosEfetuados();
	}
	
	
    public void estaoTodosPagamentosEfetuados() {
    	int contador = 0;
    	int numeroPagamentos = this.listaPagamentos.size(); 
    	
	    if(numeroPagamentos != 0){
	    	
	    	for (int i = 0 ; i < numeroPagamentos ; i++) {
	    		if(this.listaPagamentos.get(i).isStatusInadiplencia()) {
	    			contador = contador + 1;
	    		} 
	    	}
	    	
	    	if(contador > 0) {
	    		this.statusDeTodosPagamentos = "INADIMPLENTE";
	    	} else {
	    		this.statusDeTodosPagamentos = "OK";
	    	}
	    	
	   	} else {this.statusDeTodosPagamentos = "";}
    	
    }
	
	public String getStatusDeTodosPagamentos() {
		estaoTodosPagamentosEfetuados();
		return statusDeTodosPagamentos;
	}
	
	
	
	
}
