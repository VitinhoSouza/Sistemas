package br.com.ufc.model;

import java.util.HashMap;
import java.util.Map;

public class Professor extends Pessoa {

	private String titulo;
	private int siap;
	private static int proxSiap = 1;
	private Map<Integer, Disciplina> disciplinas;

	public Professor(String nome, String cpf, String titulo) {
		super(nome, cpf);
		this.titulo = titulo;
		this.siap = proxSiap;
		proxSiap++;
		this.disciplinas = new HashMap<Integer, Disciplina>();
	}

	public Professor() {

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

	// Imprimir disciplinas
	public void mostrarDisciplina(Map<Integer, Disciplina> disciplinas) {
		for (Disciplina disciplina : disciplinas.values()) {
			System.out.println(disciplina);
		}
	}

	// Lançar notas
	public void lancarNota(Disciplina disciplina, Aluno aluno, Avaliacao avaliacao) {
		if (aluno.isSitucacaoMatricula() == true) {
			disciplina.getListAvaliacao().add(avaliacao);
		}
	}
	
	// metodos para gerar polimorfismo
	public void ocupacaoAtual() {
		if(this.isOcupado() == true) {
			System.out.println(this.getNome() + " está lecionando!");
		}else {
			System.out.println(this.getNome() + " não está lecionando!");
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
		return super.toString() + "Professor [titulo=" + titulo + ", siap=" + siap + ", disciplinas=" + disciplinas.size() + "]";
	}

}
