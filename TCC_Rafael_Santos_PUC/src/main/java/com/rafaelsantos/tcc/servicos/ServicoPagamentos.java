package com.rafaelsantos.tcc.servicos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafaelsantos.tcc.controladores.AjusteData;
import com.rafaelsantos.tcc.entidades.Aluno;
import com.rafaelsantos.tcc.entidades.Pagamento;
import com.rafaelsantos.tcc.repositorios.RepositorioAlunos;
import com.rafaelsantos.tcc.repositorios.RepositorioPagamentos;

@Service
public class ServicoPagamentos {

	private RepositorioPagamentos repositorioDePagamento;

	private RepositorioAlunos repositoriodeAlunos;

	@Autowired
	public ServicoPagamentos(RepositorioPagamentos repositorioDePresenca, RepositorioAlunos repositorioDeAlunos) {
		this.repositorioDePagamento = repositorioDePresenca;
		this.repositoriodeAlunos = repositorioDeAlunos;
		 popularPagamentosNoBanco();
	}
	

	public void popularPagamentosNoBanco() {
		List<Pagamento> listaPagamentos = new ArrayList<>();
		int quantidadeAlunos = 36;
		int limiteDia = 28;
		int limiteMes = 12;
		int inicioAno = 2019;
		int fimAno = 2021;
		Random random1 = new Random();
		Random random2 = new Random();

		for (int idAluno = 1; idAluno <= quantidadeAlunos; idAluno++) {
			Aluno aluno = this.repositoriodeAlunos.findById(idAluno).get();
			for (int ano = inicioAno; ano <= fimAno; ano++) {
				for (int mes = 1; mes <= limiteMes; mes++) {
					for (int dia = 1; dia <= limiteDia; dia++) {
						
						//Adiciona apenas com Data de Vencimento no caso do Valor aleatório Random1 for verdadeiro.
						if (random1.nextBoolean()){
							  Pagamento pagamentoX = new Pagamento(aluno, 
			                  AjusteData.createDateFromDateString(String.format("%d-%d-%d %d:%d", dia, mes, ano, random1.nextInt(24), random1.nextInt(60))));
							  	 
								//Adiciona um Pagamento o caso do Valor aleatório Random2 for verdadeiro. Caso contrário, só será cadastrado o vencimento.
			                  	 if(random2.nextBoolean()) {
			                  		pagamentoX.setDataPagamento(AjusteData.createDateFromDateString(String.format("%d-%d-%d %d:%d", dia, mes, ano, random2.nextInt(24), random2.nextInt(60))));
							  	 }
							  listaPagamentos.add(pagamentoX);
						}
					}
				}
			}
		}
// Codigo para teste das 3 Condições : Pago, Atrasado e A Pagar.		

//		Aluno aluno1 = this.repositoriodeAlunos.findById(1).get();
//		Aluno aluno2 = this.repositoriodeAlunos.findById(2).get();
//		Aluno aluno3 = this.repositoriodeAlunos.findById(3).get();
//		
//		listaPagamentos.add(new Pagamento(aluno1, 
//                AjusteData.createDateFromDateString(String.format("%d-%d-%d %d:%d", 15, 01, 2020, 1, 30)),
//				AjusteData.createDateFromDateString(String.format("%d-%d-%d %d:%d", 15, 01, 2020, 1, 30))));
//		
//		listaPagamentos.add(new Pagamento(aluno2,
//				AjusteData.createDateFromDateString(String.format("%d-%d-%d %d:%d", 15, 02, 2020, 13, 14))));
//		
//		listaPagamentos.add(new Pagamento(aluno3, 
//                AjusteData.createDateFromDateString(String.format("%d-%d-%d %d:%d", 15, 9, 2020, 1, 30))));		
		
		this.repositorioDePagamento.saveAll(listaPagamentos);		
	}
	
	
	public void cadastrarPagamentoNoBanco(Aluno aluno) {
		List<Pagamento> lista = aluno.getListaPagamentos();
		
		int i=0;
		int idPagamento = -1;
		
		System.out.println("#########Aluno########"+aluno.getNome()+"###############");

		for(i=0; i<lista.size();i++) {
		
			System.out.println("------------Fatura----"+i+"---------------------");
			System.out.println("Vencimento "+ i + " = " +lista.get(i).getDataVencimento());
		
			if(lista.get(i).getDataPagamento() == null) {
				idPagamento = i;
				i = lista.size();
			    System.out.println("Pagamento "+ i + " =  Null");   
			} else {
			    System.out.println("Pagamento "+ i + " = " + lista.get(i).getDataPagamento());   
			}
		}
		
		if(idPagamento != -1)
		{
	    	Date today = Calendar.getInstance().getTime();
			//lista.get(idPagamento).setDataPagamento(AjusteData.createDateFromDateString("31-12-2020"));
	    	lista.get(idPagamento).setDataPagamento(today);
		    System.out.println("Salvou Aluno pq o Pagamento era Null");   
			this.repositoriodeAlunos.save(aluno);
		}
	
	}

	/**
	 * Função responsável pela recuperação da lista de presenças do banco
	 * de dados.
	 * 
	 * @return Lista de presencas.
	 */
	public List<Pagamento> recuperarListadePagamentosdoBanco() {
		return this.repositorioDePagamento.findAll();
	}
	
	public Map<String, Integer> recuperarEstatisticaPresenca(Aluno aluno) {
		Map<String, Integer> map = new HashMap<>();
		
		List<Pagamento> listaPagamentos = aluno.getListaPagamentos();
		
		for (Pagamento pagamento : listaPagamentos) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(pagamento.getDataPagamento());
			String ano = String.valueOf(calendar.get(Calendar.YEAR));
			if (map.containsKey(ano)) {
				Integer quantidade = map.get(ano);
				map.put(ano, quantidade+1);
			} else {
				map.put(ano, 1);
			}
		}
		
		return map;
	}


	
	
	
}
