package com.rafaelsantos.tcc.entidades;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.thymeleaf.standard.processor.AbstractStandardDoubleAttributeModifierTagProcessor;

@Entity
public class Pagamento {

	 @Id
	    @GeneratedValue
	    private int id;
	    
	    private Date dataVencimento;
	    private Date dataPagamento;
	    private boolean statusInadiplencia; 
	    
		@ManyToOne
	    @JoinColumn
	    private Aluno aluno;
	    
	    public Pagamento() {}
	    
	    public Pagamento(Aluno aluno, Date dataVencimento,Date dataPagamento) {
			this.aluno = aluno;
			this.dataVencimento = dataVencimento;
			this.dataPagamento = dataPagamento;
			setStatusInadiplencia(false);
		}
		   
	    
	    public Pagamento(Aluno aluno, Date dataVencimento) {
			this.aluno = aluno;
			this.dataVencimento = dataVencimento;
			checarStatusInadiplencia();
		}
	    
	    private void checarStatusInadiplencia(){
			
	    	Date today = Calendar.getInstance().getTime();

	    	if(today.compareTo(this.dataVencimento) > 0 && this.dataPagamento == null) {
	    		setStatusInadiplencia(true);
	    	} else {
	    	    setStatusInadiplencia(false);
	    	}
	    	
	    	 
	    }

		@Override
	    public String toString() {
		return " Id_Presença='" + this.id + '\'' + 
			", Nome Aluno ='" + this.aluno.getNome() + '\'' +
			", Data de Vencimento ='" + this.dataVencimento + '\'' +
			", Data da Pagamento ='" + this.dataPagamento + "\'";
	    }

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public Date getDataVencimento() {
			return dataVencimento;
		}

		public void setDataVencimento(Date dataVencimento) {
			this.dataVencimento = dataVencimento;
		}

		public Date getDataPagamento() {
			return dataPagamento;
		}

		public void setDataPagamento(Date dataPagamento) {
			this.dataPagamento = dataPagamento;
			setStatusInadiplencia(false);
		}

		public Aluno getAluno() {
			return aluno;
		}

		public void setAluno(Aluno aluno) {
			this.aluno = aluno;
		}
		
	    public boolean isStatusInadiplencia() {
			return statusInadiplencia;
		}

		public void setStatusInadiplencia(boolean statusInadiplencia) {
			this.statusInadiplencia = statusInadiplencia;
		}
		
		public String faturaEstaPaga(){
			
			String saida;
			if(this.dataPagamento != null){
				saida = "Pago";
			} else if (this.statusInadiplencia) {
				saida = "Atrasado";
			} else {
				saida = "A Pagar";
			} 
			
			return saida;
		}		    
	    
	    
}
