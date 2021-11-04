package org.generation.blogPessoal.repository;

import java.util.List;

import org.generation.blogPessoal.model.ModelPostagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPostagem extends JpaRepository<ModelPostagem, Long> {

	public List<ModelPostagem> findAllByTituloContainingIgnoreCase(String titulo);

}
