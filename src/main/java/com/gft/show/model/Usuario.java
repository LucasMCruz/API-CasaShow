package com.gft.show.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Usuario{
	@Id
	//@GeneratedValue(strategy = GenerationType.)
	private String username;
	private String nome;
	
	@JsonIgnore
	private String password;
	private boolean adm;
	//@ManyToMany
	//@JoinTable(name = "usuarios_roles", joinColumns = @JoinColumn(name="user_id", referencedColumnName="username"), inverseJoinColumns = @JoinColumn(name="role_id", referencedColumnName="nomeRole"))
	/*private List<Role> roles;

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}*/


	public String getNome() {
		return nome;
	}
	public void setNome(String username) {
		this.nome = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdm() {
		return adm;
	}

	public void setAdm(boolean adm) {
		this.adm = adm;
	}
	
	
	
}




