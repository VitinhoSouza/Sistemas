package br.com.ufc.sistema;

import java.util.Scanner;

import br.com.ufc.model.Aluno;
import br.com.ufc.model.Avaliacao;
import br.com.ufc.model.Curso;
import br.com.ufc.model.Disciplina;
import br.com.ufc.model.Instituicao;
import br.com.ufc.model.Professor;

public class Sistema {
	public static void main(String[] args) throws Exception {
		
		Scanner scan = new Scanner(System.in);
		int opcao,opcao2;
		
		System.out.println("Qual o nome da instituição?");
		String nome_instituicao = scan.next();
		Instituicao instituicao = new Instituicao(nome_instituicao);
		System.out.println("Instituicao criada com sucesso!");
		
		do {
			System.out.println("------------------------------");
			System.out.println("Digite 1 para CRIAR");
			System.out.println("Digite 2 para ações de ALUNO");
			System.out.println("Digite 3 para ações de PROFESSOR ");
			System.out.println("Digite 4 para ações de CURSO ");
			System.out.println("Digite 5 para ações de DISCIPLINA ");
			System.out.println("Digite 6 para ações de BUSCA ");
			System.out.println("Digite 7 para encerrar!");
			System.out.println("-------------------------------");
			opcao = scan.nextInt();
			
			if(opcao == 1) {// ações de criação
				System.out.println("------------------------------");
				System.out.println("Digite 1 para criar Professor");
				System.out.println("Digite 2 para criar Aluno (precisa ter um curso existente)");
				System.out.println("Digite 3 para criar Curso");
				System.out.println("Digite 4 para criar Disciplina (precisa ter um professor existente)");
				System.out.println("Digite 5 para voltar");
				System.out.println("-------------------------------");
				opcao2 = scan.nextInt();
				
				if(opcao2 == 1) { // criando professor
					System.out.println("Qual o nome do professor?");
					String nome = scan.next();
					System.out.println("Qual o cpf do professor?");
					String cpf = scan.next();
					System.out.println("Qual o titulo do professor?");
					String titulo = scan.next();
					Professor prof = new Professor(nome, cpf, titulo);
					instituicao.addProfessor(prof);
					System.out.println("Professor criado com sucesso");
				}else if(opcao2 == 2) { // criando aluno
					System.out.println("Qual o nome do aluno?");
					String nome = scan.next();
					System.out.println("Qual o cpf do aluno?");
					String cpf = scan.next();
					System.out.println("Qual o codigo do curso do aluno?");
					int codCurso = scan.nextInt();
					Aluno aluno = new Aluno(nome,cpf,false,true,instituicao.getCursos().get(codCurso));
					instituicao.matricularAluno(aluno);
					System.out.println("Aluno criado com sucesso");
					
				}else if(opcao2 == 3) {// criando curso
					System.out.println("Qual o nome do curso?");
					String nome = scan.next();
					System.out.println("Qual o coordenador do curso?");
					String coo = scan.next();
					System.out.println("Qual a carga horária do curso?");
					int carga = scan.nextInt();
					Curso curso = new Curso(nome, coo,carga);
					instituicao.addCurso(curso);
					System.out.println("Curso criado com sucesso!");
				}else if(opcao2 == 4) {// criando Disciplina
					System.out.println("Qual o nome da disciplina?");
					String nome = scan.next();
					System.out.println("Qual o siap do professor da disciplina?");
					int siap = scan.nextInt();
					System.out.println("Quantos créditos a disciplina tem?");
					int credito = scan.nextInt();
					Disciplina disciplina = new Disciplina(nome,credito,instituicao.getProfessores().get(siap));
					instituicao.addDisciplina(disciplina);
					System.out.println("Disciplina criada com sucesso!");
				}else if(opcao2 == 5) {
					System.out.println("Voltando...");
				}else {
					System.out.println("Opção inválida!");
				}
				
			}else if(opcao == 2) {// Ações de aluno
				System.out.println("Digite a matrícula do aluno");
				int mat = scan.nextInt();
				
				System.out.println("------------------------------");
				System.out.println("Digite 1 para adicionar disciplina");
				System.out.println("Digite 2 para mostrar disciplinas");
				System.out.println("Digite 3 para gerar histórico");
				System.out.println("Digite 4 para ver notas de uma disciplina");
				System.out.println("Digite 5 para ver ocupação");
				System.out.println("Digite 6 para mudar ocupação");
				System.out.println("Digite 7 para voltar");
				System.out.println("-------------------------------");
				opcao2 = scan.nextInt();
				
				if(opcao2 == 1) { // adicionando disciplina
					System.out.println("Digite o codigo da disciplina");
					int cod = scan.nextInt();
					instituicao.getAlunos().get(mat).addDisciplina(instituicao.getDisciplinas().get(cod));
					System.out.println("Disciplina adicionada ao aluno com sucesso!");
				}else if(opcao2 == 2) { // mostrando disciplinas
					instituicao.getAlunos().get(mat).mostrarDisciplinas();
				}else if(opcao2 == 3) {// ver historico
					instituicao.getAlunos().get(mat).verHistorico();
				}else if(opcao2 == 4) {// ver notas de uma disciplina
					System.out.println("Digite o codigo da disciplina");
					int cod = scan.nextInt();
					instituicao.getAlunos().get(mat).verNotas(cod);
				}else if(opcao2 == 5) {// ver ocupação
					instituicao.getAlunos().get(mat).ocupacaoAtual();
				}else if(opcao2 == 6) {// mudar ocupação
					instituicao.getAlunos().get(mat).mudarOcupacao();
				}else if(opcao2 == 7) {
					System.out.println("Voltando...");
				}else {
					System.out.println("Opção inválida!");
				}
				
			}else if(opcao == 3) {// Ações de professor
				System.out.println("Digite o siap do professor");
				int siap = scan.nextInt();
				
				System.out.println("------------------------------");
				System.out.println("Digite 1 para imprimir disciplinas");
				System.out.println("Digite 2 para lançar notas");
				System.out.println("Digite 3 para ver ocupação");
				System.out.println("Digite 4 para mudar ocupação");
				System.out.println("Digite 5 para voltar");
				System.out.println("-------------------------------");
				opcao2 = scan.nextInt();
				
				if(opcao2 == 1) { // imprimir disciplinas
					instituicao.getProfessores().get(siap).mostrarDisciplina(instituicao.getDisciplinas());
				}else if(opcao2 == 2) { // lançar nota
					System.out.println("Digite a matrícula do aluno");
					int mat = scan.nextInt();
					System.out.println("Digite o codigo da disciplina");
					int codigo = scan.nextInt();
					System.out.println("Digite a primeira nota");
					int nota = scan.nextInt();
					System.out.println("Digite a segunda nota");
					int nota2 = scan.nextInt();
					Avaliacao av = new Avaliacao(nota, nota2, instituicao.getAlunos().get(mat));
					instituicao.getProfessores().get(siap).lancarNota(instituicao.getDisciplinas().get(codigo), 
							instituicao.getAlunos().get(mat), av);
					System.out.println("Nota lançada!");
				}else if(opcao2 == 3) {// ver ocupação
					instituicao.getProfessores().get(siap).ocupacaoAtual();
				}else if(opcao2 == 4) {// mudar ocupação
					instituicao.getProfessores().get(siap).mudarOcupacao();
				}else if(opcao2 == 5) {
					System.out.println("Voltando...");
				}else {
					System.out.println("Opção inválida!");
				}
				
			}else if(opcao == 4) { // ações do curso
				System.out.println("Digite o codigo do curso");
				int codigo = scan.nextInt();
				
				System.out.println("------------------------------");
				System.out.println("Digite 1 para matricular aluno no curso");
				System.out.println("Digite 2 para jubilar aluno");
				System.out.println("Digite 3 para mostrar alunos do curso");
				System.out.println("Digite 4 para voltar");
				System.out.println("-------------------------------");
				opcao2 = scan.nextInt();
				
				if(opcao2 == 1) {//matricular aluno
					System.out.println("Digite a matricula do aluno");
					int mat = scan.nextInt();
					instituicao.getCursos().get(codigo).matricularAluno(instituicao.getAlunos().get(mat));
					System.out.println("Aluno matriculado com sucesso!");
				}else if(opcao2 == 2){//jubilar aluno
					System.out.println("Digite a matricula do aluno");
					int mat = scan.nextInt();
					instituicao.getCursos().get(codigo).jubilarAluno(instituicao.getAlunos().get(mat));
				}else if(opcao2 ==  3) {// mostrar aluno
					instituicao.getCursos().get(codigo).mostrarAlunos();
				}else if(opcao2 == 4) {
					System.out.println("Voltando...");
				}else {
					System.out.println("Opção inválida!");
				}
				
			}else if(opcao == 5) {// ações da disciplina
				System.out.println("Digite o codigo da disciplina");
				int codigo = scan.nextInt();
				
				System.out.println("------------------------------");
				System.out.println("Digite 1 para matricular aluno à disciplina");
				System.out.println("Digite 2 para mostrar alunos da disciplina");
				System.out.println("Digite 3 para verificar aprovação de um aluno");
				System.out.println("Digite 4 para calcular media geral da turma");
				System.out.println("Digite 5 para adicionar avaliação");
				System.out.println("Digite 6 para voltar");
				System.out.println("-------------------------------");
				opcao2 = scan.nextInt();
				
				if(opcao2 == 1) { // matricular aluno
					System.out.println("Digite a matricula do aluno");
					int mat = scan.nextInt();
					instituicao.getDisciplinas().get(codigo).matricularAluno(instituicao.getAlunos().get(mat));
					System.out.println("Aluno matriculado!");
				}else if(opcao2 == 2) {// mostrar alunos
					instituicao.getDisciplinas().get(codigo).mostrarAlunosMatriculados();
				}else if(opcao2 == 3) { //verificar aprovação de um aluno
					System.out.println("Digite a matricula do aluno");
					int mat = scan.nextInt();
					instituicao.getDisciplinas().get(codigo).verificaAprovacao(instituicao.getAlunos().get(mat));
				}else if(opcao2 == 4) {//calcular media
					System.out.println(instituicao.getDisciplinas().get(codigo).calcularMedia());
				}else if(opcao2 == 5) {// adicionar avaliacao
					System.out.println("Digite a matrícula do aluno");
					int mat = scan.nextInt();
					System.out.println("Digite a primeira nota");
					int nota = scan.nextInt();
					System.out.println("Digite a segunda nota");
					int nota2 = scan.nextInt();
					Avaliacao av = new Avaliacao(nota, nota2, instituicao.getAlunos().get(mat));
					instituicao.getDisciplinas().get(codigo).addAvaliacao(av);
					System.out.println("Nota lançada!");
				}else if(opcao2 == 6) {
					System.out.println("Voltando...");
				}else {
					System.out.println("Opção inválida!");
				}
				
			}else if(opcao == 6) {//ações de busca
				System.out.println("------------------------------");
				System.out.println("Digite 1 para mostrar alunos");
				System.out.println("Digite 2 para mostrar professores");
				System.out.println("Digite 3 para mostrar cursos");
				System.out.println("Digite 4 para buscar um aluno em específico");
				System.out.println("Digite 5 voltar");
				System.out.println("-------------------------------");
				opcao2 = scan.nextInt();
				
				if(opcao2 == 1) {// mostrar alunos
					System.out.println("Alunos do/da " + instituicao.getNome());
					instituicao.mostrarAlunos();
				}else if(opcao2 == 2) {// mostrar profs
					System.out.println("Professores do/da " + instituicao.getNome());
					instituicao.mostrarProfessores();
				}else if(opcao2 == 3) {// mostrar cursos
					System.out.println("Cursos do/da " + instituicao.getNome());
					instituicao.mostrarCursos();
				}else if(opcao2 == 4) {// buscar aluno
					System.out.println("Digite a matricula do aluno");
					int mat = scan.nextInt();
					if(instituicao.buscarAluno(mat) == true){
						System.out.println(instituicao.getAlunos().get(mat));
					}else {
						System.out.println("Aluno não encontrado!");
					}
				}else if(opcao2 == 5) {
					System.out.println("Voltando...");
				}else {
					System.out.println("Opção inválida!");
				}
			}
			
			else if(opcao == 7) {
				System.out.println("Encerrando...");
				break;
			}else {
				System.out.println("Opção inválida!");
			}
			
		}while(opcao != 7);
		
		
	}
}
