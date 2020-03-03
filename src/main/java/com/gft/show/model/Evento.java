package com.gft.show.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;




@Entity
public class Evento {
	@JsonInclude(Include.NON_NULL)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@JsonInclude(Include.NON_NULL)
	@NotEmpty(message = "Evento é obrigatoria")
	@Size(max = 60, message = "A descrição nao pode conter mais de 60 caracteres")
	private String nomeEvento;
	
	@JsonInclude(Include.NON_NULL)
	@NotNull(message = "Capacidade não pode ser nulo")
	@DecimalMin(value = "1.00", message = "Capacidade tem que ser maior que 0" )
	private int capacidade;
	
	@JsonInclude(Include.NON_NULL)
	@NotNull(message = "Data de fabricação obrigatoria")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dataEvento;
	
	@JsonInclude(Include.NON_NULL)
	@NotNull(message = "Valor de venda não pode ser nulo")
	@DecimalMin(value = "0.01", message = "Valor nao pode ser menor que 0,01" )
	@NumberFormat(pattern = "#,##0.00")
	private BigDecimal valor;
	
	@JsonInclude(Include.NON_NULL)
	@Enumerated(EnumType.STRING)
	private StatusEvento status;
	
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	@ManyToOne
	@NotNull(message = "Selecione ou crie uma Casa de Show")
	private CasaShow casaShow;
	
	//@ManyToMany
	//private List<Historico> historico;
	
	@JsonInclude(Include.NON_NULL)
	private int qtdingresso = capacidade;

	/*private String casaShow;
	
	
	public String getCasaShow() {
		return casaShow;
	}

	public void setCasaShow(String casaShow) {
		this.casaShow = casaShow;
	}*/

	public CasaShow getCasaShow() {
		return casaShow;
	}

	public void setCasaShow(CasaShow casaShow) {
		this.casaShow = casaShow;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	

	public String getNomeEvento() {
		return nomeEvento;
	}

	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
		public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public Date getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(Date dataEvento) {
		this.dataEvento = dataEvento;
	}
	

	public StatusEvento getStatus() {
		return status;
	}

	public void setStatus(StatusEvento status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Evento other = (Evento) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	public int getQtdingresso() {
		return qtdingresso;
	}

	public void setQtdingresso(int qtdingresso) {
		this.qtdingresso = qtdingresso;
	}

	

	
	
	

}
