package br.com.filipeconstante.tutoriais.model;

import java.io.Serializable;

public class ModelObject implements Serializable {

	private static final long serialVersionUID = 1113799434508676095L;
	private Integer id;
	private String nome;
	private String email;
	private Boolean status;

	public ModelObject() {
	}

	public ModelObject(Integer id, String nome, String email, Boolean status) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}
