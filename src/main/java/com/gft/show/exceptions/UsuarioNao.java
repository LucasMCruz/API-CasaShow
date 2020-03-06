package com.gft.show.exceptions;

public class UsuarioNao extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6904390836155115853L;
	public UsuarioNao(String mensagem) {
		super(mensagem);
	}
	public UsuarioNao(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}