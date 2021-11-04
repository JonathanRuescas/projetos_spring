
package org.generation.blogPessoal.controller;

import java.util.List;

import org.generation.blogPessoal.model.ModelPostagem;
import org.generation.blogPessoal.repository.RepositoryPostagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/postagem")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class ControllerPostagem {

	@Autowired
	private RepositoryPostagem repositoryPostagem;

	@GetMapping
	public ResponseEntity<List<ModelPostagem>> getAll() {
		return ResponseEntity.ok(repositoryPostagem.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<ModelPostagem> GetByid(@PathVariable long id) {
		return repositoryPostagem.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<ModelPostagem>> GetByTitulo(@PathVariable String titulo) {
		return ResponseEntity.ok(repositoryPostagem.findAllByTituloContainingIgnoreCase(titulo));
	}

	@PostMapping
	public ResponseEntity<ModelPostagem> postPostagem(@RequestBody ModelPostagem tabBlog) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repositoryPostagem.save(tabBlog));

	}

	@PutMapping
	public ResponseEntity<ModelPostagem> putPostagem(@RequestBody ModelPostagem tabBlog) {
		return ResponseEntity.status(HttpStatus.OK).body(repositoryPostagem.save(tabBlog));

	}

	@DeleteMapping("/{id}")
	public void deletePostagem(@PathVariable long id) {
		repositoryPostagem.deleteById(id);
	}

}