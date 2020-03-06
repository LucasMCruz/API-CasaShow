package com.gft.show.handler;

import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.support.InvocableHandlerMethod;

import com.gft.show.model.DetalheErro;
import com.gft.show.exceptions.*;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(CasaNao.class)
	public ResponseEntity<DetalheErro> handleiCasaNao(CasaNao e, HttpServletRequest request){
		
		DetalheErro erro = new DetalheErro();
		erro.setStatus(404l);
		erro.setTitulo("Casa ja existe");
		erro.setMensagemDesenvolvedor("Leia a Documentação");
		erro.setTimestamp(System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	@ExceptionHandler(EventoNAo.class)
	public ResponseEntity<DetalheErro> handleiNao(EventoNAo e, HttpServletRequest request){
		
		DetalheErro erro = new DetalheErro();
		erro.setStatus(409l);
		erro.setTitulo("O Evento existente");
		erro.setMensagemDesenvolvedor("Leia a Documentação");
		erro.setTimestamp(System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<DetalheErro> handleiConstraintViolationException(ConstraintViolationException e, HttpServletRequest request){
		
		DetalheErro erro = new DetalheErro();
		erro.setStatus(400l);
		erro.setTitulo("Requisição invalida");
		erro.setMensagemDesenvolvedor("Leia a Documentação");
		erro.setTimestamp(System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<DetalheErro> handleiNoSuchElementException(NoSuchElementException e, HttpServletRequest request){
		
		DetalheErro erro = new DetalheErro();
		erro.setStatus(404l);
		erro.setTitulo("Casa De show nao encontrada");
		erro.setMensagemDesenvolvedor("Leia a Documentação");
		erro.setTimestamp(System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<DetalheErro> handleiEmptyResultDataAccessException(EmptyResultDataAccessException e, HttpServletRequest request){
		
		DetalheErro erro = new DetalheErro();
		erro.setStatus(404l);
		erro.setTitulo("Requisição invalida");
		erro.setMensagemDesenvolvedor("Leia a Documentação");
		erro.setTimestamp(System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<DetalheErro> handleiEmptyResultDataAccessException(MethodArgumentNotValidException e, HttpServletRequest request){
		
		DetalheErro erro = new DetalheErro();
		erro.setStatus(404l);
		erro.setTitulo("Casa nao encontrada para alterar");
		erro.setMensagemDesenvolvedor("Leia a Documentação");
		erro.setTimestamp(System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<DetalheErro> handleiHttpMessageNotReadableException(HttpMessageNotReadableException e, HttpServletRequest request){
		
		DetalheErro erro = new DetalheErro();
		erro.setStatus(400l);
		erro.setTitulo("Para salvar qualquer coisa precisa precisa passar os parametros corretos");
		erro.setMensagemDesenvolvedor("Leia a Documentação");
		erro.setTimestamp(System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(erro);
	}
	
	
}
