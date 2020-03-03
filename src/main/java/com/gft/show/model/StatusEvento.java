package com.gft.show.model;

public enum StatusEvento {
	ROCK("Rock"),
	AXE("Axe"),
	ELETRONICA("Eletronica");
	
	private String definicao;

	StatusEvento(String definicao){
		this.definicao= definicao; 
	}
	
	public String getDefinicao() {
		return definicao;
	}
}
