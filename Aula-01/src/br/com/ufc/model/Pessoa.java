package br.com.ufc.model;

public abstract class Pessoa implements Comparable<Pessoa> {

	private String nome;
	private String cpf;
	private boolean ocupado;

	public Pessoa(String nome, String cpf, boolean ocupado) {
		this.nome = nome;
		this.cpf = cpf;
		this.ocupado = ocupado;
	}

	public Pessoa(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}

	public Pessoa() {

	}

	public Pessoa(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

	// Metodo para gerar polimorfismo
	public void ocupacaoAtual() {

	}

	public void mudarOcupacao() {

	}

	// Metodo ordenar
	@Override
	public int compareTo(Pessoa pessoa) {
		return this.nome.compareToIgnoreCase(pessoa.getNome());
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", cpf=" + cpf + "]";
	}

}
