package com.gft.show.exceptions;

public class EventoNAo extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6904390836155115853L;
	public EventoNAo(String mensagem) {
		super(mensagem);
	}
	public EventoNAo(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}

