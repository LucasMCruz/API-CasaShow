package com.gft.show.handler;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.support.InvocableHandlerMethod;

import com.gft.show.model.DetalheErro;
import com.gft.show.exceptions.*;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(CasaNao.class)
	public ResponseEntity<DetalheErro> handleiLivroNao(CasaNao e, HttpServletRequest request){
		
		DetalheErro erro = new DetalheErro();
		erro.setStatus(404l);
		erro.setTitulo("Requisição invalida");
		erro.setMensagemDesenvolvedor("ERROORR");
		erro.setTimestamp(System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	@ExceptionHandler(EventoNAo.class)
	public ResponseEntity<DetalheErro> handleiAutoroNao(EventoNAo e, HttpServletRequest request){
		
		DetalheErro erro = new DetalheErro();
		erro.setStatus(409l);
		erro.setTitulo("O Evento existente");
		erro.setMensagemDesenvolvedor("Error 409");
		erro.setTimestamp(System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<DetalheErro> handleiConstraintViolationException(ConstraintViolationException e, HttpServletRequest request){
		
		DetalheErro erro = new DetalheErro();
		erro.setStatus(400l);
		erro.setTitulo("Requisição invalida");
		erro.setMensagemDesenvolvedor("Error 409");
		erro.setTimestamp(System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
	@ExceptionHandler(InvocableHandlerMethod.class)
	public ResponseEntity<DetalheErro> handleiInvocableHandlerMethod(InvocableHandlerMethod e, HttpServletRequest request){
		
		DetalheErro erro = new DetalheErro();
		erro.setStatus(400l);
		erro.setTitulo("Requisição invalida");
		erro.setMensagemDesenvolvedor("Error 409");
		erro.setTimestamp(System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}

	
}
