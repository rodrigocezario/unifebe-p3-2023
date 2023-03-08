package br.edu.unifebe.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.unifebe.modelo.Marca;

public class MarcaDao extends AbstractDao implements IDao<Marca> {

//	private Connection conexao;
//	
//	public MarcaDao() {
//		this.conexao = Conexao.getConnection();
//	}

	@Override
	public void salvar(Marca e) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Marca> listaTodos() {
		String sql = "SELECT * FROM Marca";
		List<Marca> marcas = new ArrayList();

		try {
			PreparedStatement prmt = this.conexao.prepareStatement(sql);
			ResultSet rs = prmt.executeQuery();
			while (rs.next()) {

				Marca marca = new Marca();
				marca.setId(rs.getInt("MarcaID"));
				marca.setNome(rs.getString("MarcaNome"));
				marca.setSite(rs.getString("MarcaSite"));

				marcas.add(marca);

			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return marcas;
	}

	@Override
	public Marca buscar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void atualizar(Marca e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void excluir(int id) {
		// TODO Auto-generated method stub

	}

}
