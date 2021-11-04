package org.generation.blogPessoal.repository;

import java.util.List;

import org.generation.blogPessoal.model.ModelTema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryTema extends JpaRepository<ModelTema, Long> {
	public List<ModelTema> findAllByDescricaoContainingIgnoreCase( String Descricao);
}