package br.edu.unifebe.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.edu.unifebe.modelo.Marca;

public class MarcaDao extends AbstractDao implements IDao<Marca> {

//	private Connection conexao;
//	
//	public MarcaDao() {
//		this.conexao = Conexao.getConnection();
//	}

	@Override
	public boolean salvar(Marca e) {
		String sql = "insert into Marca (MarcaNome, MarcaSite, MarcaStatus) " + "values (?, ?, ?)";
		try {
			PreparedStatement prmt = this.conexao.prepareStatement(sql);
			prmt.setString(1, e.getNome());
			prmt.setString(2, e.getSite());
			prmt.setBoolean(3, e.isStatus());
			prmt.execute();
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
		return true;

	}

	@Override
	public List<Marca> listaTodos() {
		String sql = "SELECT * FROM Marca";
		List<Marca> marcas = new ArrayList<Marca>();

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
		String sql = "select * from Marca where MarcaID = ?";
		Optional<Marca> marca = Optional.empty();

		try {
			PreparedStatement prmt = this.conexao.prepareStatement(sql);
			prmt.setInt(1, id);
			ResultSet rs = prmt.executeQuery();

			if (rs.next()) {
				Marca m = new Marca();
				m.setId(rs.getInt("MarcaID"));
				m.setNome(rs.getString("MarcaNome"));
				m.setSite(rs.getString("MarcaSite"));
				m.setStatus(rs.getBoolean("MarcaStatus"));

				marca = Optional.of(m);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return marca.get();
	}

	@Override
	public void atualizar(Marca e) {
		String sql = "update Marca set MarcaNome = ?, MarcaSite = ?, " + "MarcaStatus = ? where MarcaID = ?";
		try {
			PreparedStatement prmt = this.conexao.prepareStatement(sql);
			prmt.setString(1, e.getNome());
			prmt.setString(2, e.getSite());
			prmt.setBoolean(3, e.isStatus());
			prmt.setInt(4, e.getId());

			prmt.execute();

		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	public void excluir(int id) {
		String sql = "delete from Marca where MarcaID = ?";
		try {
			PreparedStatement prmt = this.conexao.prepareStatement(sql);
			prmt.setInt(1, id);

			prmt.execute();

		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}

	}

}
