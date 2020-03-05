package com.gft.show.exceptions;

public class HistoricoNao extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6904390836155115853L;
	public HistoricoNao(String mensagem) {
		super(mensagem);
	}
	public HistoricoNao(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}