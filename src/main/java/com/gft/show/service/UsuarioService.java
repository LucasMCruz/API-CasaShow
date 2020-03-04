package com.gft.show.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.show.model.Usuario;
import com.gft.show.repository.UserRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UserRepository usuaRe;
	
	public List<Usuario> listar(){
		return usuaRe.findAll();
	}

}
