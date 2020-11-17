package br.com.ufc.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Instituicao {

	// atributos
	private String nome;
	private Map<Integer, Professor> professores;
	private Map<Integer, Curso> cursos;
	private Map<Integer, Aluno> alunos;
	private Map<Integer, Disciplina> disciplinas;

	// Construtor
	public Instituicao(String nome) {
		this.nome = nome;
		this.professores = new HashMap<Integer, Professor>();
		this.cursos = new HashMap<Integer, Curso>();
		this.alunos = new HashMap<Integer, Aluno>();
		this.disciplinas = new HashMap<Integer, Disciplina>();
	}

	// Construtor vazio
	public Instituicao() {
	}

	// Get e Set
	public String getNome() {
		return nome;
	}

	public Map<Integer, Professor> getProfessores() {
		return professores;
	}

	public Map<Integer, Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public Map<Integer, Curso> getCursos() {
		return cursos;
	}

	public Map<Integer, Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(Map<Integer, Aluno> alunos) {
		this.alunos = alunos;
	}

	// Adicionar curso
	public void addCurso(Curso curso) throws Exception {
		if (cursos.containsKey(curso.getNome())) {
			throw new Exception("Erro || Curso já cadastrado. ");
		}
		cursos.put(curso.getCodigo(), curso);
	}
	
	// Adicionar Disciplina
		public void addDisciplina(Disciplina disciplina) throws Exception {
			if (disciplinas.containsKey(disciplina.getCodigoDisciplina())) {
				throw new Exception("Erro || Disciplina já cadastrado. ");
			}
			disciplinas.put(disciplina.getCodigoDisciplina(), disciplina);
		}

	// Mostrar cursos
	public void mostrarCursos() {
		for (Curso curso : cursos.values()) {
			System.out.println(curso.getNome());
		}
	}

	// Buscar aluno
	public boolean buscarAluno(int matricula) throws Exception {
		if (alunos.containsKey(matricula)) {
			return true;
		}else {
			return false;
		}
	}

	// Adicionar prfessor
	public void addProfessor(Professor professor) throws Exception {
		if (professores.containsKey(professor.getSiap())) {
			throw new Exception("Erro || Professor já cadastrado. ");
		}

		professores.put(professor.getSiap(), professor);
	}

	// mostrar professores
	public void mostrarProfessores() {
		List<Professor> listProfessor = new ArrayList<>(professores.values());
		Collections.sort(listProfessor);
		for (Professor professor : listProfessor) {
			System.out.println(professor);
		}
	}

	// Adicionar alunos
	public void matricularAluno(Aluno aluno) throws Exception {
		if (alunos.containsKey(aluno.getMatricula())) {
			throw new Exception("Erro || Aluno já matriculado na Instituição.");
		}
		alunos.put(aluno.getMatricula(), aluno);
	}

	// mostrar alunos
	public void mostrarAlunos() {
		List<Aluno> listAluno = new ArrayList<>(alunos.values());
		Collections.sort(listAluno);
		for (Aluno aluno : listAluno) {
			System.out.println(aluno);
		}
	}

	
}
