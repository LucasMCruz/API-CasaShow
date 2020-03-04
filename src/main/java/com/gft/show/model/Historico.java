package com.gft.show.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Historico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long IDevento;
	
	private String evento;
	
	private int ingresso;
	
	private BigDecimal preco;
	
	public Historico(Long IDevento, String evento, int ingresso, BigDecimal valor) {
		super();
		IDevento = IDevento;
		this.evento = evento;
		this.ingresso = ingresso;
		this.preco = valor;
	}
	public Historico(){}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Long getIDevento() {
		return IDevento;
	}
	public void setIDevento(Long iDevento) {
		IDevento = iDevento;
	}
	public String getEvento() {
		return evento;
	}
	public void setEvento(String evento) {
		this.evento = evento;
	}
	public int getIngresso() {
		return ingresso;
	}
	public void setIngresso(int ingresso) {
		this.ingresso = ingresso;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Historico other = (Historico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
}
