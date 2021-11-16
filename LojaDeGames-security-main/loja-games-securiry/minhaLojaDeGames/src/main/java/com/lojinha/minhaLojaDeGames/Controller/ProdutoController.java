package com.lojinha.minhaLojaDeGames.Controller;

import java.util.List;

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


import com.lojinha.minhaLojaDeGames.Repository.ProdutoRepository;
import com.lojinha.minhaLojaDeGames.model.Produto;

@RestController // explicando para o spring que esta é nossa camada controller
@RequestMapping("/produto")
@CrossOrigin (origins = "*", allowedHeaders = "*") //origem da requisição
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping
	public ResponseEntity<List<Produto>> getAll(){ //select * from tb_produto
		return ResponseEntity.ok(produtoRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> getById(@PathVariable long id) {
		return produtoRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build()); 
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Produto>> GetByNome(@PathVariable String nome){
		return ResponseEntity.ok(produtoRepository.findAllByNomeContainingIgnoreCase(nome));
							
	}


	@PostMapping
	public ResponseEntity<Produto> postProduto(@RequestBody Produto produto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto)); // HTTP 201
	
	}
	
	@PutMapping
	public ResponseEntity<Produto> putProduto (@RequestBody Produto produto) {
		return ResponseEntity.status(HttpStatus.OK).body(produtoRepository.save(produto)); // HTTP 201
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduto(@PathVariable long id) {
		produtoRepository.deleteById(id);
		
	}
			
	}
