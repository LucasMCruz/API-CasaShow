package com.gft.show.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gft.show.model.Usuario;
import com.gft.show.service.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class ApiUsuario {
	
	@Autowired
	private UsuarioService usuaSe;
	
	@GetMapping()
	public ResponseEntity<List<Usuario>> listar(){
		System.out.println("Listando Historico de Compra");
		return ResponseEntity.status(HttpStatus.OK).body(usuaSe.listar());
	}

	

}
