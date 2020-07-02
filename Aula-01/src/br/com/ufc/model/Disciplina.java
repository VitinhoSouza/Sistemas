package br.com.ufc.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.ufc.model.Aluno;
import br.com.ufc.model.Avaliacao;

public class Disciplina {

	private String nome;
	private int creditos;
	private Professor professor;
	private int codigoDisciplina;
	private static int proxCodigo = 1;
	private Map<Integer, Aluno> alunosMatriculados;
	private List<Avaliacao> listAvaliacao;

	public Disciplina(String nome, int creditos, Professor professor) {
		this.nome = nome;
		this.creditos = creditos;
		this.professor = professor;
		this.codigoDisciplina = proxCodigo;
		proxCodigo++;
		this.alunosMatriculados = new HashMap<Integer, Aluno>();
		this.listAvaliacao = new ArrayList<Avaliacao>();
	}

	public Disciplina() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public int getCodigoDisciplina() {
		return codigoDisciplina;
	}

	public void setCodigoDisciplina(int codigoDisciplina) {
		this.codigoDisciplina = codigoDisciplina;
	}

	public static int getProxCodigo() {
		return proxCodigo;
	}

	public static void setProxCodigo(int proxCodigo) {
		Disciplina.proxCodigo = proxCodigo;
	}

	public Map<Integer, Aluno> getAlunosMatriculados() {
		return alunosMatriculados;
	}

	public void setAlunosMatriculados(Map<Integer, Aluno> alunosMatriculados) {
		this.alunosMatriculados = alunosMatriculados;
	}

	public List<Avaliacao> getListAvaliacao() {
		return listAvaliacao;
	}

	public void setListAvaliacao(List<Avaliacao> listAvaliacao) {
		this.listAvaliacao = listAvaliacao;
	}

	//Adicionar avaliaçao
	public void addAvaliacao(Avaliacao avaliacao) {
		listAvaliacao.add(avaliacao);
	}

	// Matricular aluno
	public void matricularAluno(Aluno aluno) throws Exception {
		if (alunosMatriculados.containsKey(aluno.getMatricula())) {
			throw new Exception("Erro || Aluno já matriculado na Disciplina.");
		}
		alunosMatriculados.put(aluno.getMatricula(), aluno);
	}

	// Imprimir alunos
	public void mostrarAlunosMatriculados() {
		for (Aluno aluno : alunosMatriculados.values()) {
			System.out.println(aluno);
		}
	}

	// verificar Aprovação
	public void verificaAprovacao(Aluno alunoVerificado) {
		for(Avaliacao avaliacao: listAvaliacao) {
			if(avaliacao.getAluno().getMatricula() == alunoVerificado.getMatricula()) {
				double media = (avaliacao.getNota() + avaliacao.getNota2()) / 2;
				if(media>=7) {
					System.out.println("Aluno aprovado com "+ media);
				}else {
					System.out.println("Aluno reprovado com "+ media);
				}
			}
		}
	}
	
	// calcular media geral
	public double calcularMedia() {
		double total = 0;
		for(Avaliacao avaliacao: listAvaliacao) {
			 total = total + (avaliacao.getNota() + avaliacao.getNota2());
		}
		return (total / (listAvaliacao.size()*2));
	}
	
	@Override
	public String toString() {
		return "Disciplina [nome: " + nome + ", creditos: " + creditos + ", \nprofessor: " + professor.getNome()
					+ ", \nCódigo Disciplina: " + codigoDisciplina + ", Alunos Matriculados: "
					+ alunosMatriculados.size() + ", Avaliações: " + listAvaliacao + ", Média: " + calcularMedia();
	}

}
