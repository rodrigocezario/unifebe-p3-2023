package br.edu.unifebe.testes;

import java.sql.Connection;
import java.sql.SQLException;

import br.edu.unifebe.jdbc.Conexao;

public class TesteConexao {

	public static void main(String[] args) {

		try {
			//Conexao cx = new Conexao();
			Connection conexao1 = Conexao.getConnection();
			Connection conexao2 = Conexao.getConnection();
			
			System.out.println("Conexao 1: "+ conexao1);
			System.out.println("Conexao 2: "+ conexao2);
			
			System.out.println("Conexão com db realizada com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro: "+ e.getMessage());
		}

	}

}
