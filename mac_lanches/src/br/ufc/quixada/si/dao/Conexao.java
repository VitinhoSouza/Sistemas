package br.ufc.quixada.si.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	public Connection Conectar() {
		Connection con = null;
		String url = "jdbc:postgresql://localhost:5432/mac_lanche";
		String usuario = "postgres";
		String senha = "senhafbd";
		try {
			con = DriverManager.getConnection(url,usuario,senha);
			//System.out.println("Conectado !");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return con;
}

}
