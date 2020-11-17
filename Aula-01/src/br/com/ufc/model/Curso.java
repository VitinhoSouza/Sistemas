package br.com.ufc.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Curso {

	private String nome;
	private String coordenador;
	public int cargaHoraria;
	public int codigo;
	public static int proxCodigo = 1;
	private Map<Integer, Aluno> alunosMatriculaddos;

	public Curso(String nome, String coordenador, int cargaHoraria) {
		this.nome = nome;
		this.coordenador = coordenador;
		this.cargaHoraria = cargaHoraria;
		this.codigo = proxCodigo;
		proxCodigo++;
		this.alunosMatriculaddos = new HashMap<Integer, Aluno>();
	}

	public Curso() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCoordenador() {
		return coordenador;
	}

	public void setCoordenador(String coordenador) {
		this.coordenador = coordenador;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public static int getProxCodigo() {
		return proxCodigo;
	}

	public static void setProxCodigo(int proxCodigo) {
		Curso.proxCodigo = proxCodigo;
	}

	public Map<Integer, Aluno> getAlunosMatriculaddos() {
		return alunosMatriculaddos;
	}

	public void setAlunosMatriculaddos(Map<Integer, Aluno> alunosMatriculaddos) {
		this.alunosMatriculaddos = alunosMatriculaddos;
	}

	// Matricular aluno no curso
	public void matricularAluno(Aluno aluno) throws Exception {
		if (alunosMatriculaddos.containsKey(aluno.getMatricula())) {
			throw new Exception("Erro || Aluno já cadastrado.");
		}
		alunosMatriculaddos.put(aluno.getMatricula(), aluno);
		aluno.setSitucacaoMatricula(true);
	}

	// Jubilar aluno
	public void jubilarAluno(Aluno aluno) throws Exception {
		if (aluno.isSitucacaoMatricula() == false) {
			alunosMatriculaddos.remove(aluno.getMatricula());
		}
		throw new Exception("Aluno Removido do curso.");
	}

	// Mostrar alunos do curso
	public void mostrarAlunos() {
		List<Aluno> alunos = new ArrayList<>(alunosMatriculaddos.values());
		Collections.sort(alunos);
		for (Aluno aluno : alunos) {
			System.out.println(aluno);
		}
	}
}
