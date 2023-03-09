package br.edu.unifebe.testes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.edu.unifebe.dao.MarcaDao;
import br.edu.unifebe.modelo.Marca;

class TestMarcaDaoJunit {
	
	private MarcaDao dao;

	@BeforeEach
	void setUp() throws Exception {
		this.dao = new MarcaDao();
	}

	@Test
	@DisplayName("Testando os retornos do método listaTodos")
	void listarTodos() {
		List<Marca> marcas = this.dao.listaTodos();
		assertEquals("Sony", marcas.get(0).getNome());
		assertNotNull(marcas.get(0));
	}

}
