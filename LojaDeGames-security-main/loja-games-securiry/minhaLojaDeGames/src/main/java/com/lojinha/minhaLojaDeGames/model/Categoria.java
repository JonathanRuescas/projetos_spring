package com.lojinha.minhaLojaDeGames.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// camada que indica que aqui é dedicado a criação da entidade tabela
@Table (name = "tb_categoria")
@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;

	@NotBlank(message = "Campo obrigatório")
	@Size(min = 1, max = 15, message = "O nome deverá ter no máximo 15 caracteres")
	public String genero;

	@NotBlank(message = "Campo obrigatório")
	public String plataforma;

	@NotBlank(message = "Campo obrigatório")
	public String condicao;

	// mappedby --> qual o lado inverso da operação
	// cascade --> o que uma tabela fizer, funcionará nas outras
	// @JsonIgnoreProperties --> deleta as repetições e só mostra onde está alocado

	// 1: N
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL) //SELECT TABLE INNER JOIN -- ON
	@JsonIgnoreProperties("categoria")
	private List<Produto> produto;

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public String getCondicao() {
		return condicao;
	}

	public void setCondicao(String condicao) {
		this.condicao = condicao;
	}

}
