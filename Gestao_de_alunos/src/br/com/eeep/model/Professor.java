package br.com.eeep.model;

import java.util.HashMap;
import java.util.Map;

public class Professor extends Pessoa {

	private String titulo;
	private int siap;
	private static int proxSiap = 1;

	private Map<Integer, Disciplina> disciplinas;

	public Professor() {

	}

	public Professor(String nome, String cpf, boolean ocupado, String titulo) {
		super(nome, cpf, ocupado);
		this.titulo = titulo;
		this.siap = proxSiap;
		this.proxSiap++;

		this.disciplinas = new HashMap<Integer, Disciplina>();
	}

	public Professor(String nome) {
		super(nome);
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getSiap() {
		return siap;
	}

	public void setSiap(int siap) {
		this.siap = siap;
	}

	public static int getProxSiap() {
		return proxSiap;
	}

	public static void setProxSiap(int proxSiap) {
		Professor.proxSiap = proxSiap;
	}

	public Map<Integer, Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(Map<Integer, Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public void lancarNotas(Disciplina disciplina, Aluno aluno,  Avaliacao avaliacao) {
		
	}
	
	public void mostrarDisciplinas() {
		
	}

	@Override
	public String toString() {
		return super.toString() + "Professor [titulo=" + titulo + ", siap=" + siap + ", disciplinas=" + disciplinas
				+ "]";
	}

}
