package br.ufc.quixada.si.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufc.quixada.si.model.Pedido;
import br.ufc.quixada.si.model.Pessoa;
import br.ufc.quixada.si.model.Produto;

public class PedidoDao {
	private Connection con;
	private PreparedStatement stm;
	private ResultSet rs;
	private List<Pedido> pedidos = new ArrayList<>();
	
	public PedidoDao() {
		this.con = new Conexao().Conectar();
	}
	
	public void inserir(Pedido ped){
		String sql = "insert into pedido(cod_produto,id_pessoa) values(?,?)";
		String sql2 = "select quantidade from produto where cod_produto = ? ";
		try {
			PreparedStatement pro = con.prepareStatement(sql);
			PreparedStatement pro2 = con.prepareStatement(sql2);
			pro2.setInt(1,ped.getCod_produto());
			ResultSet rs2 = pro2.executeQuery();
			rs2.next();
			int quant = rs2.getInt("quantidade");
			//System.out.println(quant);
			if(quant==0) {
				System.out.println("Produto em falta!");
			}else {
				pro.setInt(1,ped.getCod_produto());
				pro.setInt(2,ped.getId_pessoa());
				pro.execute();
				System.out.println("Pedido feito(acesse o relatório de pedidos para verificar seu código)!");
				con.close();
			}
		}catch(SQLException e) {
			System.out.println("Não foi possível realizar pedido!");
		}
	}
	
	public void remover(Pedido ped) throws SQLException{
		String sql = "delete from pedido where cod_pedido = ?";
		try {
			PreparedStatement pro = con.prepareStatement(sql);
			pro.setInt(1,ped.getCodigo());
			int rows = pro.executeUpdate();
			if(rows==1) {
				System.out.println("Pedido removido!");
			}else {
				System.out.println("Erro na remoção!");
			}
			con.close();
		}catch(SQLException e) {
			System.out.println("falha!");
		}
	}
	
	public void editar(Pedido ped) throws SQLException{
		String sql = "update pedido set cod_produto = ? where cod_pedido = ?";
		try {
			PreparedStatement pro = con.prepareStatement(sql);
			pro.setInt(1,ped.getCod_produto());
			pro.setInt(2,ped.getCodigo());
			pro.execute();
			System.out.println("Pedido alterado!");
			con.close();
		}catch(SQLException e) {
			System.out.println("falha!");
		}
	}
	public void listar(int cod_pedido) throws SQLException{
		String sql = "select ped.cod_pedido,pro.cod_produto,pro.nome_prod,pes.id_pessoa,pes.nome from pedido ped,produto pro,pessoa pes" + 
					 " where ped.cod_produto = pro.cod_produto and ped.id_pessoa = pes.id_pessoa and ped.cod_pedido = ?";
		try {
			PreparedStatement pro = con.prepareStatement(sql);
			pro.setInt(1, cod_pedido);
			ResultSet rs = pro.executeQuery();
			while(rs.next()) {
				Pessoa pes = new Pessoa(0,"padrao");
				Produto prod = new Produto();
				Pedido ped = new Pedido(rs.getInt("cod_pedido"),prod,pes);
				pes.setId(rs.getInt("id_pessoa"));
				pes.setNome(rs.getString("nome"));
				prod.setCodigo(rs.getInt("cod_produto"));
				prod.setNome(rs.getString("nome_prod"));
				System.out.print("Código do pedido: " + ped.getCodigo());
				System.out.print(", Código do cliente: "+pes.getId());
				System.out.print(", Nome do cliente: "+pes.getNome());
				System.out.print(", Código do produto: "+prod.getCodigo());
				System.out.println(", Nome do produto: "+prod.getNome());
			}
			rs.close();
			pro.close();
		}catch(SQLException e) {
			System.out.println("Pedido não encontrado!");
		}
	}
	public void listar() throws SQLException{
		String sql = "select * from historico5";
		try {
			PreparedStatement pro = con.prepareStatement(sql);

			ResultSet rs = pro.executeQuery();
			while(rs.next()) {
				Pessoa pes = new Pessoa(0,"padrao");
				Produto prod = new Produto();
				Pedido ped = new Pedido(rs.getInt("cod_pedido"),prod,pes);
				pes.setId(rs.getInt("id_pessoa"));
				pes.setNome(rs.getString("nome_cliente"));
				prod.setCodigo(rs.getInt("cod_produto"));
				prod.setNome(rs.getString("nome_produto"));
				prod.setPreco(rs.getDouble("preco_produto"));
				System.out.print("Código do pedido: " + ped.getCodigo());
				System.out.print(", Código do cliente: "+pes.getId());
				System.out.print(", Nome do cliente: "+pes.getNome());
				System.out.print(", Código do produto: "+prod.getCodigo());
				System.out.print(", Nome do produto: "+prod.getNome());
				System.out.println(", Preço do produto: "+prod.getPreco());
			}
			rs.close();
			pro.close();
		}catch(SQLException e) {
			System.out.println("Nenhum pedido encontrado!");
		}
	}
	public void listar_valor(int codcli) throws SQLException{
		String sql = "select soma_pedidos(?)";
		try {
			PreparedStatement pro = con.prepareStatement(sql);
			pro.setInt(1, codcli);
			ResultSet rs = pro.executeQuery();
			rs.next();
			System.out.println("Valor gasto: "+rs.getDouble("soma_pedidos"));
			rs.close();
			pro.close();
		}catch(SQLException e) {
			System.out.println("Nenhum pedido encontrado!");
		}
	}
}
