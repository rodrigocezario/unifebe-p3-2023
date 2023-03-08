package br.edu.unifebe.dao;

import java.sql.Connection;
import java.sql.SQLException;

import br.edu.unifebe.jdbc.Conexao;

public abstract class AbstractDao {
	
	protected Connection conexao;
	
	public AbstractDao() {
		try {
			this.conexao = Conexao.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao acessar db: "+ e.getMessage());
		}
	}
	
}
