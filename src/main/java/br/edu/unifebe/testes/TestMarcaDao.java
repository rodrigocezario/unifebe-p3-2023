package br.edu.unifebe.testes;

import java.util.List;

import br.edu.unifebe.dao.MarcaDao;
import br.edu.unifebe.modelo.Marca;

public class TestMarcaDao {

	public static void main(String[] args) {
		
		MarcaDao dao = new MarcaDao();
		
		Marca marca = new Marca();
		marca.setNome("UNIFEBE - SI - TESTE");
		marca.setSite("unifebe.edu.br");
		marca.setStatus(true);
		marca.setId(35);

		//dao.salvar(marca);
		//dao.atualizar(marca);
		//dao.excluir(34);
		
		System.out.println("=======================");
		
		int codigo = 1;
		Marca marcaDetalhe = dao.buscar(codigo);
		
		System.out.println("Detalhes código: "+ codigo + " => "+ marcaDetalhe.getNome());
		
		System.out.println("=======================");
		
		//lista tudo
		List<Marca> marcas = dao.listaTodos();
		
		marcas.forEach(m -> {
			System.out.println("=> "+ m.getNome());
		});
		
		//PROXIMO ENCONTRO: Interface fluent
		
	}

}
