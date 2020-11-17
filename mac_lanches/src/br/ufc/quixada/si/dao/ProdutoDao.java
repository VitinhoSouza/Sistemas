package br.ufc.quixada.si.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufc.quixada.si.model.Pessoa;
import br.ufc.quixada.si.model.Produto;

public class ProdutoDao {
	
	private Conexao jdbc = new Conexao();
	private Connection con;
	private PreparedStatement stm;
	private ResultSet rs;
	private List<Produto> produtos = new ArrayList<>();
	
	public ProdutoDao() {
		this.con = new Conexao().Conectar();
	}
	
	public void inserir(Produto prod) {

		String sql = "insert into produto(preco,quantidade,nome_prod) values(?,?,?)";
		try {
			if(prod.getNome()!=null && prod.getPreco()!=0 && prod.getQuantidade()!=0) {
				PreparedStatement pro = con.prepareStatement(sql);
			//ResultSet rs = pro.executeQuery();
				pro.setDouble(1,prod.getPreco());
				pro.setInt(2,prod.getQuantidade());
				pro.setString(3,prod.getNome());
				pro.execute();
				//prod.setCodigo(((ResultSet) pro).getInt("cod_produto"));
				System.out.println("Produto inserido(acesse o relatório de produtos para verificar seu código)!");
				con.close();
			}else {
				System.out.println("Campo nulo!");
			}
		}catch(SQLException e) {
			System.out.println("falha!");
		}
	}
	
	public void remover(Produto prod) throws SQLException{
		String sql = "delete from produto where cod_produto = ?";
		try {
			PreparedStatement pro = con.prepareStatement(sql);
			pro.setInt(1,prod.getCodigo());
			int rows = pro.executeUpdate();
			if(rows==1) {
				System.out.println("Produto removido!");
			}else {
				System.out.println("Erro na remoção!");
			}
			con.close();
		}catch(SQLException e) {
			System.out.println("falha!");
		}
	}
	
	public void editar(Produto prod) throws SQLException{
		String sql = "update produto set preco = ?, quantidade = ?, nome_prod = ? where cod_produto = ?";
		try {
			PreparedStatement pro = con.prepareStatement(sql);
			pro.setDouble(1,prod.getPreco());
			pro.setInt(2,prod.getQuantidade());
			pro.setString(3,prod.getNome());
			pro.setInt(4,prod.getCodigo());
			pro.execute();
			System.out.println("Produto alterado!");
			con.close();
		}catch(SQLException e) {
			System.out.println("falha!");
		}
	}
	public void listar(int cod_produto) throws SQLException{
		String sql = "select * from produto where cod_produto = ?";
		try {
			PreparedStatement pro = con.prepareStatement(sql);
			
			pro.setInt(1, cod_produto);

			ResultSet rs = pro.executeQuery();
			while(rs.next()) {
				Produto prod = new Produto(rs.getInt("cod_produto"),2.5,10,"padrão");
				prod.setPreco(rs.getDouble("preco"));
				prod.setQuantidade(rs.getInt("quantidade"));
				prod.setNome(rs.getString("nome_prod"));
				System.out.println(prod);
			}
			rs.close();
			pro.close();
		}catch(SQLException e) {
			System.out.println("Produto não encontrado!");
		}
	}
	public void listar() throws SQLException{
		String sql = "select * from produto";
		try {
			List<Produto> ListaProduto = new ArrayList<Produto>();
			PreparedStatement pro = con.prepareStatement(sql);

			ResultSet rs = pro.executeQuery();
			while(rs.next()) {
				Produto prod = new Produto(rs.getInt("cod_produto"),2.5,10,"padrão");
				prod.setPreco(rs.getDouble("preco"));
				prod.setQuantidade(rs.getInt("quantidade"));
				prod.setNome(rs.getString("nome_prod"));
				ListaProduto.add(prod);
			}
			System.out.println(ListaProduto);
			rs.close();
			pro.close();
		}catch(SQLException e) {
			System.out.println("Produto não encontrado!");
		}
	}

}
