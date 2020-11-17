package br.ufc.quixada.si.model;

public class Produto {
	
	 private String nome;
	 private double preco;
	 private int quantidade;
	 private int codigo;
	    
	 public Produto(int codigo, double preco, int quantidade, String nome){
		 this.nome = nome;
	     this.preco = preco;
	     this.quantidade = quantidade;
	     this.codigo = codigo;
	 }
	    
	    public Produto(){
	    
	    }

	    public String getNome() {
	        return nome;
	    }

	    public void setNome(String nome) {
	        this.nome = nome;
	    }

	    public double getPreco() {
	        return preco;
	    }

	    public void setPreco(double preco) {
	        this.preco = preco;
	    }

	    public int getQuantidade() {
	        return quantidade;
	    }

	    public void setQuantidade(int quantidade) {
	        this.quantidade = quantidade;
	    }

	    public int getCodigo() {
	        return codigo;
	    }

	    public void setCodigo(int codigo) {
	        this.codigo = codigo;
	    }
	    
	    @Override
	    public String toString(){
	        return "\n----------------------" + "\nCodigo: " + this.codigo + "\nProduto: " 
	               + this.nome + "\nPreço: " + this.preco + "\nQuantidade: " + this.quantidade +
	               "\n----------------------\n";        
	    }

}
