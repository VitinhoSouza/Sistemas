package br.com.ufc.model;

public class Avaliacao {
	private Aluno aluno;
	private double nota;
	private double nota2;

	public Avaliacao(double nota, double nota2, Aluno aluno) {
		super();
		this.nota = nota;
		this.nota2 = nota2;
		this.aluno = aluno;
	}

	public double getNota() {
		return nota;
	}

	public double getNota2() {
		return nota2;
	}

	public Aluno getAluno() {
		return aluno;
	}

	@Override
	public String toString() {
		return "[Ap1: " + nota + ", Ap2: " + nota2 + "]";
	}

}
