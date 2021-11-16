package com.lojinha.minhaLojaDeGames.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lojinha.minhaLojaDeGames.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	public Optional<Usuario> findByUsuario(String usuario);

}
