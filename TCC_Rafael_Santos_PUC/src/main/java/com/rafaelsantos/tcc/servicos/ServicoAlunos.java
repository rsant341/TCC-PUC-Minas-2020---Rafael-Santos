package com.rafaelsantos.tcc.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafaelsantos.tcc.entidades.Aluno;
import com.rafaelsantos.tcc.repositorios.RepositorioAlunos;

@Service
public class ServicoAlunos {


    private RepositorioAlunos repositoriodeAlunos;
    

    @Autowired
    public ServicoAlunos(RepositorioAlunos repositoriodeAlunos) {
	this.repositoriodeAlunos = repositoriodeAlunos;
	cadastrarAlunosnoBancoInicial();
    }
        
    public void cadastrarAlunoNoBanco(Aluno aluno) {
 	this.repositoriodeAlunos.save(aluno);
    }
    

    public Aluno recuperarAlunodoBanco(Integer id) {
	Aluno aluno = this.repositoriodeAlunos.findById(id).get(); 
	return aluno;
    }
    

    public List<Aluno> recuperarListadeAlunosdoBanco() {
	List<Aluno> ListaAlunosRecuperados = this.repositoriodeAlunos.findAll(); 
	//Impressão de Aluno Recuperados para necessidade de Debug
	//ListaAlunosRecuperados.forEach(alunoRecuperado ->{System.out.println(alunoRecuperado.toString());});
	return ListaAlunosRecuperados;
    }

    public void cadastrarAlunosnoBancoInicial() {
		this.repositoriodeAlunos.save(new Aluno(12451,"Rafaela Araujo","111.222.333-44","12", "Rua A","Mensal"));
		this.repositoriodeAlunos.save(new Aluno(12452,"Jonathan Junior","111.222.333-44","832", "Rua B","Mensal"));
		this.repositoriodeAlunos.save(new Aluno(12453,"Leonardo Dias","111.222.333-44","433", "Rua C","Mensal"));
		this.repositoriodeAlunos.save(new Aluno(12454,"Rafael Cajazeiras","111.222.333-44","171", "Rua D","Mensal"));
		this.repositoriodeAlunos.save(new Aluno(12455,"Daiane Brito","111.222.333-44","939", "Rua E","Mensal"));
		this.repositoriodeAlunos.save(new Aluno(12456,"Eduardo Chaves","111.222.333-44","4531", "Rua F","Mensal"));
		this.repositoriodeAlunos.save(new Aluno(12457,"Jessica Ribeiro","111.222.333-44","2", "Rua G","Mensal"));
		this.repositoriodeAlunos.save(new Aluno(12458,"Roberto Costa","111.222.333-44","14", "Rua H","Mensal"));
		this.repositoriodeAlunos.save(new Aluno(12459,"Tamiris Silva","111.222.333-44","27", "Rua I","Mensal"));
		this.repositoriodeAlunos.save(new Aluno(12460,"Matheus Medina","111.222.333-44","888", "Rua J","Mensal"));
		this.repositoriodeAlunos.save(new Aluno(12461,"Luiza Lobão","111.222.333-44","744", "Rua K","Mensal"));
		this.repositoriodeAlunos.save(new Aluno(12462,"Luiza Sonza","111.222.333-44","786", "Rua L","Mensal"));
		this.repositoriodeAlunos.save(new Aluno(12463,"Winderson Nunes","111.222.333-44","1001", "Rua M","Mensal"));
		this.repositoriodeAlunos.save(new Aluno(12464,"Danielli Rocha","111.222.333-44","1458", "Rua N","Mensal"));
		this.repositoriodeAlunos.save(new Aluno(12465,"Adriana Neves","111.222.333-44","7", "Rua O","Mensal"));
		this.repositoriodeAlunos.save(new Aluno(12466,"Claudio Aguiar","111.222.333-44","77", "Rua P","Mensal"));
		this.repositoriodeAlunos.save(new Aluno(12467,"Aldemar Cossolino","111.222.333-44","7454", "Rua Q","Mensal"));
		this.repositoriodeAlunos.save(new Aluno(12468,"Thiago Brazileiro","111.222.333-44","4856", "Rua R","Mensal"));
		this.repositoriodeAlunos.save(new Aluno(12469,"Maylon Nascimento","111.222.333-44","88954", "Rua S","Anual"));
		this.repositoriodeAlunos.save(new Aluno(12470,"Carolina Silva","111.222.333-44","714235", "Rua T","Anual"));
		this.repositoriodeAlunos.save(new Aluno(12471,"Ramon Souza","111.222.333-44","785", "Rua U","Anual"));
		this.repositoriodeAlunos.save(new Aluno(12472,"Matheuz Cruz","111.222.333-44","74", "Rua V","Anual"));
		this.repositoriodeAlunos.save(new Aluno(12472,"Carlos Hess","111.222.333-44","245", "Rua X","Anual"));
		this.repositoriodeAlunos.save(new Aluno(12473,"Vagner Santos","111.222.333-44","365", "Rua Z","Anual"));
		this.repositoriodeAlunos.save(new Aluno(12474,"Juliette Nobrega","111.222.333-44","555", "Rua Y","Anual"));
		this.repositoriodeAlunos.save(new Aluno(12475,"Larissa Costa","111.222.333-44","675", "Rua W","Anual"));
		this.repositoriodeAlunos.save(new Aluno(12476,"Diogo Henrique","111.222.333-44","897", "Rua TT","Anual"));
		this.repositoriodeAlunos.save(new Aluno(12477,"Marcos Ferraz","111.222.333-44","55", "Rua PP","Anual"));
		this.repositoriodeAlunos.save(new Aluno(12478,"Eraldo Carlos","111.222.333-44","2222", "Rua J1","Anual"));
		this.repositoriodeAlunos.save(new Aluno(12479,"Ana Cristina","111.222.333-44","2224", "Rua VP","Anual"));
		this.repositoriodeAlunos.save(new Aluno(12480,"Jamile Pimentel","111.222.333-44","7754", "Rua DCV","Anual"));
		this.repositoriodeAlunos.save(new Aluno(12481,"Jurandy America","111.222.333-44","321", "Rua M1","Anual"));
		this.repositoriodeAlunos.save(new Aluno(12482,"Laysa Borges","111.222.333-44","123", "Rua UNV2","Anual"));
		this.repositoriodeAlunos.save(new Aluno(12483,"Tiago Custódio","111.222.333-44","889", "Rua UPV2","Anual"));
		this.repositoriodeAlunos.save(new Aluno(12484,"Wagner Feitosa","111.222.333-44","414", "Rua TPV","Anual"));;
		this.repositoriodeAlunos.save(new Aluno(12485,"Leandro Silva","111.222.333-44","654", "Rua VEV","Anual"));
    }   
	
}
