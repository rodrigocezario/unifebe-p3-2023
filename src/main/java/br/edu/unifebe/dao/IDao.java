package br.edu.unifebe.dao;

import java.util.List;

public interface IDao<E> {
	
	//CRUD
	boolean salvar(E e);
	
	List<E> listaTodos();
	E buscar(int id);
	
	void atualizar(E e);
	
	void excluir(int id);

}
