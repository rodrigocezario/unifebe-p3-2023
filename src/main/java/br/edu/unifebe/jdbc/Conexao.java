package br.edu.unifebe.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private static String URL = "jdbc:mysql://localhost:3306/dbloja?useSSL=false";
	private static String USER = "root";
	private static String PWS = "senhasecreta";

	private static Connection conexao;

	private Conexao() {

	}

	public static Connection getConnection() throws SQLException {
		if (conexao == null) {
			conexao = DriverManager.getConnection(URL, USER, PWS);
		}
		return conexao;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Não é permitido clonar singleton");
	}
	

}
