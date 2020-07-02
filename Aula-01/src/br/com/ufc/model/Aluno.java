package br.com.ufc.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.ufc.model.Avaliacao;
import br.com.ufc.model.Disciplina;

public class Aluno extends Pessoa {

	private int matricula;
	private static int proxMatricula = 1;
	private boolean situcacaoMatricula;
	private Curso curso;

	Map<Integer, Disciplina> disciplinas;

	public Aluno(String nome, String cpf, boolean ocupado, boolean situacaoMatricula, Curso curso) {
		super(nome, cpf, ocupado);
		this.matricula = proxMatricula;
		this.situcacaoMatricula = situacaoMatricula;
		this.curso = curso;
		proxMatricula++;
		this.disciplinas = new HashMap<Integer, Disciplina>();
	}

	public Aluno(String nome) {
		super(nome);
	}

	public Aluno() {

	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public static int getProxMatricula() {
		return proxMatricula;
	}

	public static void setProxMatricula(int proxMatricula) {
		Aluno.proxMatricula = proxMatricula;
	}

	public boolean isSitucacaoMatricula() {
		return situcacaoMatricula;
	}

	public void setSitucacaoMatricula(boolean situcacaoMatricula) {
		this.situcacaoMatricula = situcacaoMatricula;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Map<Integer, Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(Map<Integer, Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	// Adicionar disciplinas
	public void addDisciplina(Disciplina disciplina) throws Exception {
		if (disciplinas.containsKey(disciplina.getCodigoDisciplina()) && disciplinas.size() <= 8) {
			throw new Exception("Erro || Não foi possível matricular nessa disciplina.");
		}
		disciplinas.put(disciplina.getCodigoDisciplina(), disciplina);
	}

	// Mostrar disciplinas
	public void mostrarDisciplinas() {
		for (Disciplina disciplina : disciplinas.values()) {
			System.out.println(disciplina.getNome());
		}
	}

	// Gerar historico
	public void verHistorico() {
		for (Disciplina disciplina : disciplinas.values()) {
			System.out.println(disciplina);
		}
	}

	//Ver notas de uma disciplina específica
	public void verNotas(Integer codigoDisciplina) {
		if(disciplinas.containsKey(codigoDisciplina)) {//se o aluno ja fez a disciplina
			for(Disciplina disciplina2 : disciplinas.values()) {//irei procurar a disciplina no HashMap de disciplinas
				if(codigoDisciplina == disciplina2.getCodigoDisciplina()) {//se eu achar a disciplina
					List<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();
					avaliacoes = disciplina2.getListAvaliacao();//pego todas as avaliacoes da disciplina
					for(Avaliacao av : avaliacoes) {//irei procurar as notas na lista de avaliacoes
						if(av.getAluno().getMatricula() == this.getMatricula()) {//se achar o aluno certo
							System.out.println("Aluno: "+this.getNome() + " Matrícula: "  +this.getMatricula() + " Nota1: " 
							+ av.getNota() + " Nota2: " + av.getNota2());
						}
						System.out.println("Teste5");
					}
				}
			}
		}else {
			System.out.println("Disciplina não encontrada no histórico do aluno!");
		}
	}
	
	// metodos para gerar polimorfismo
	public void ocupacaoAtual() {
		if(this.isOcupado() == true) {
			System.out.println(this.getNome() + " está estudando!");
		}else {
			System.out.println(this.getNome() + " não está estudando!");
		}

	}

	public void mudarOcupacao() {
		if(this.isOcupado() == true) {
			this.setOcupado(false);
		}else {
			this.setOcupado(true);
		}
	}

	@Override
	public String toString() {
		if (this.situcacaoMatricula == true) {
			return super.toString() + " Aluno [matricula=" + matricula + ", situcacaoMatricula=" + "Ativo" + ", curso="
					+ curso.getNome() + "]";
		}
		return super.toString() + " Aluno [matricula=" + matricula + ", situcacaoMatricula=" + "Inativo" + ", curso="
				+ curso.getNome() + "]";
	}

}
