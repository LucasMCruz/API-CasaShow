package com.gft.show.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
public class CasaShow {

	@JsonInclude(Include.NON_NULL)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@JsonInclude(Include.NON_NULL)
	@NotEmpty(message = "Descrição é obrigatoria")
	@Size(max = 60, message = "A descrição nao pode conter mais de 60 caracteres")
	private String nome;
	
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "casaShow")
	private List<Evento> evento;
	

	
	public List<Evento> getEvento() {
		return evento;
	}


	public void setEvento(List<Evento> evento) {
		this.evento = evento;
	}

	@NotEmpty(message = "Descrição é obrigatoria")
	@Size(max = 60, message = "A descrição nao pode conter mais de 60 caracteres")
	private String endereco;

	public Long getCodigo() {
		return codigo;
	}


	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (codigo ^ (codigo >>> 32));
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CasaShow other = (CasaShow) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}




	
	
	
}