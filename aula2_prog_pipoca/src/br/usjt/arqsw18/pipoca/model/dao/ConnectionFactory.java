package br.usjt.arqsw18.pipoca.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection getConnection() throws SQLException{
		String stringConexao = "jdbc:mysql://localhost:3306/filmes_banco_aula2";
		String usuario = "alunos";
		String senha = "alunos";
		return DriverManager.getConnection(stringConexao, usuario, senha);
		
	}

}
