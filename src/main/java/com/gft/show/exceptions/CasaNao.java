package com.gft.show.exceptions;

public class CasaNao extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6904390836155115853L;
	public CasaNao(String mensagem) {
		super(mensagem);
	}
	public CasaNao(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}