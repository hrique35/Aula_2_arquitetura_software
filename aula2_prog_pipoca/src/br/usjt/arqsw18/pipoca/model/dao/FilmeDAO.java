package br.usjt.arqsw18.pipoca.model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.usjt.arqsw18.pipoca.model.entity.Filme;

public class FilmeDAO {

	public int inserirFilme(Filme filme) throws SQLException, IOException {
		// especificar o comando sql de insercao de um filme
		// pre compilar o comando sql
		// executar o comando
		// pre compilar o comando sql que permite a obtenção do ultimo id gerado na
		// sessão atual
		// devolver o id gerado
		int id = -1;
		String sql = "insert into filmes_banco_aula2 (nome_filme, descricao_filme)  values (?,?)";

		try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) {

			pst.setString(1, filme.getNome());
			pst.setString(2, filme.getDescricao());
			// obter o id criado
			String query = "select LAST_INSERT_ID()";
			try (PreparedStatement pst1 = conn.prepareStatement(query); ResultSet rs = pst1.executeQuery();) {
				if (rs.next()) {
					id = rs.getInt(1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		return id;
	}

}