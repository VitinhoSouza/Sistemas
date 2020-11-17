package br.ufc.quixada.si.model;

public class Pedido {
	private int codigo;
    private int cod_produto;
    private int id_pessoa;
    
    
    public Pedido(int codigo, Produto prod, Pessoa pessoa){
        this.codigo = codigo;
        this.cod_produto = prod.getCodigo();
        this.id_pessoa = pessoa.getId();
    }
    
    public Pedido(){
    
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

	public int getCod_produto() {
		return cod_produto;
	}

	public void setCod_produto(int cod_produto) {
		this.cod_produto = cod_produto;
	}

	public int getId_pessoa() {
		return id_pessoa;
	}

	public void setId_pessoa(int id_pessoa) {
		this.id_pessoa = id_pessoa;
	}

	@Override
	public String toString() {
		return "Pedido [codigo=" + codigo + ", cod_produto=" + cod_produto + ", id_pessoa=" + id_pessoa + "]\n";
	}

}
