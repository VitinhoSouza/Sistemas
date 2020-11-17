package br.com.eeep.model;

import java.util.HashMap;
import java.util.Map;

public class Aluno extends Pessoa {

	private int matricula;
	private static int proxMatricula = 1;
	private boolean situacaoMatricula;
	private Curso curso;

	Map<Integer, Disciplina> disciplinas;

	public Aluno() {

	}

	public Aluno(String nome, String cpf, boolean ocupado, boolean situacaoMatricula, Curso curso) {
		super(nome, cpf, ocupado);
		this.matricula = proxMatricula;
		this.situacaoMatricula = situacaoMatricula;
		this.curso = curso;
		proxMatricula++;

		this.disciplinas = new HashMap<Integer, Disciplina>();
	}

	public Aluno(String nome) {
		super(nome);
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

	public boolean isSituacaoMatricula() {
		return situacaoMatricula;
	}

	public void setSituacaoMatricula(boolean situacaoMatricula) {
		this.situacaoMatricula = situacaoMatricula;
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

	// adicionar disciplinas
	public void addDisciplina(Disciplina disciplina) throws Exception{
//		if(disciplinas.containsKey(disciplina).getCodigo()) && disciplinas.size() <=8 ) {
//		throw new Exception("ERRO| nao foi possivel se maricular");
//		}
//		disciplinas.put(disciplina.getCodigo(),disciplina);
	}

	// mostrar disciplinas
	public void mostrarDisciplinas() {
		for(Disciplina disciplina : disciplinas.values()) {
			System.out.println(disciplina);
		}
	}

	// ver histórico
	public void verHistorico() {

	}

	// ver notas
	public void verNotas(Disciplina disciplina) {

	}

	@Override
	public String toString() {
		if (this.situacaoMatricula == true) {
			return super.toString() + "Aluno [matricula=" + matricula + ", situacaoMatricula = Ativo" + ", curso="
					+ curso + ", disciplinas=" + disciplinas + "]";
		}
		return super.toString() + "Aluno [matricula=" + matricula + ", situacaoMatricula = Inativo" + ", curso=" + curso
				+ ", disciplinas=" + disciplinas + "]";
	}

}
