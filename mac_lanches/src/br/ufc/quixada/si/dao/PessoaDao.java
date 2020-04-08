package br.ufc.quixada.si.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufc.quixada.si.model.*;

public class PessoaDao {
	private Conexao jdbc = new Conexao();
	private Connection con;
	private PreparedStatement stm;
	private ResultSet rs;
	private List<Pessoa> pessoas = new ArrayList<>();
	
	public PessoaDao() {
		this.con = new Conexao().Conectar();
	}
	
	public void inserir(Pessoa pes) throws SQLException{
		String sql = "insert into pessoa(nome) values(?)";
		try {
			PreparedStatement pro = con.prepareStatement(sql);
			pro.setString(1,pes.getNome());
			pro.execute();
			System.out.println("Cliente cadastrado(acesse o relatório de clientes para verificar seu código)!");
			con.close();
		}catch(SQLException e) {
			System.out.println("falha!");
		}
	}
	
	public void remover(Pessoa pes) throws SQLException{
		String sql = "delete from pessoa where id_pessoa = ?";
		try {
			PreparedStatement pro = con.prepareStatement(sql);
			pro.setInt(1,pes.getId());
			int rows = pro.executeUpdate();
			if(rows==1) {
				System.out.println("Pessoa removida!");
			}else {
				System.out.println("Erro na remoção!");
			}
			con.close();
		}catch(SQLException e) {
			System.out.println("falha!");
		}
	}
	
	public void editar(Pessoa pes) throws SQLException{
		String sql = "update pessoa set nome = ? where id_pessoa = ?";
		try {
			PreparedStatement pro = con.prepareStatement(sql);
			pro.setString(1,pes.getNome());
			pro.setInt(2,pes.getId());
			pro.execute();
			System.out.println("Cliente alterado!");
			con.close();
		}catch(SQLException e) {
			System.out.println("falha!");
		}
	}
	
	public void listar(int id_pessoa) throws SQLException{
		String sql = "select * from pessoa where id_pessoa = ?";
		try {
			PreparedStatement pro = con.prepareStatement(sql);
			pro.setInt(1, id_pessoa);

			ResultSet rs = pro.executeQuery();
			while(rs.next()) {
				Pessoa pes = new Pessoa(rs.getInt("id_pessoa"), "padrão");
				pes.setNome(rs.getString("nome"));
				System.out.println(pes);
			}
			rs.close();
			pro.close();
		}catch(SQLException e) {
			System.out.println("Pessoa não encontrada!");
		}
	}
	public void listar() throws SQLException{
		String sql = "select * from pessoa";
		try {
			List<Pessoa> ListaPessoa = new ArrayList<Pessoa>();
			PreparedStatement pro = con.prepareStatement(sql);
	
			ResultSet rs = pro.executeQuery();
			while(rs.next()) {
				Pessoa pes = new Pessoa(rs.getInt("id_pessoa"), "padrão");
				pes.setNome(rs.getString("nome"));
				ListaPessoa.add(pes);
			}
			System.out.println(ListaPessoa);
			rs.close();
			pro.close();
		}catch(SQLException e) {
			System.out.println("Pessoa não encontrada!");
		}
	}

}
