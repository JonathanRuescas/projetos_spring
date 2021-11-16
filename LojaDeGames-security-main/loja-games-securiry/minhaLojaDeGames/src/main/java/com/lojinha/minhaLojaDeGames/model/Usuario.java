package com.lojinha.minhaLojaDeGames.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb-usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotBlank(message = "Campo obrigatorio")
	@Size(max = 15)
	private String Usuario;

	@NotBlank(message = "Campo obrigatorio")
	@Size(max = 15)
	private String nome;

	@NotBlank(message = "Campo obrigatorio")
	@Size(max = 30)
	@Email
	private String email;

	@NotBlank(message = "Campo obrigatorio")
	private String senha;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL) // SELECT TABLE INNER JOIN -- ON
	@JsonIgnoreProperties("usuario")
	private List<Produto> produto;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsuario() {
		return Usuario;
	}

	public void setUsuario(String Usuario) {
		this.Usuario = Usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}

}
