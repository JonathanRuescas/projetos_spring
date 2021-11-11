package br.org.generation.farmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.generation.farmacia.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	public List <Produto> findAllByNomeContainingIgnoreCase(String nome);
	
	/**
	 *  Método Personalizado - Buscar por Nome do Produto e pelo Nome do Laboratório
	 *  
	 *  MySQL: select * from tb_produtos where nome = "produto" and laboratorio = "laboratorio";
	 */
	 
	public List <Produto> findByNomeAndLaboratorio(String nome, String laboratorio);
	
	/**
	 *  Método Personalizado - Buscar por Nome do Produto ou pelo Nome do Laboratório
	 *  
	 *  MySQL: select * from tb_produtos where nome = "produto" or laboratorio = "laboratorio";
	 */
	public List <Produto> findByNomeOrLaboratorio(String nome, String laboratorio);

}
