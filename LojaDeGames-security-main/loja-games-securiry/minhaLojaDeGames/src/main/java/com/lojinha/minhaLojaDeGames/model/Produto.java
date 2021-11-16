package com.lojinha.minhaLojaDeGames.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;

	@NotBlank(message = "Campo obrigatório")
	@Size(min = 3 , max = 100, message = "O nome deverá ter no máximo 100 caracteres")
	public String nome;

	@NotNull(message = "Campo obrigatório")
	public double preco;
	
	// CHAVE ESTRANGEIRA
	@ManyToOne // N: 1
	@JsonIgnoreProperties("categoria") //não permitir que repita as informações
	@JoinColumn(name = "fk_id_categoria")
	private Categoria categoria;
	
	

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

}
