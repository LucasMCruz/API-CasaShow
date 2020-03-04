package com.gft.show.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gft.show.model.Historico;
import com.gft.show.service.HistoricoService;

import io.swagger.annotations.Api;


@Api(tags="Historico de compra")
@RestController
@RequestMapping("/api/historico")
public class ApiHistorico {
	
	@Autowired
	private HistoricoService histSe;
	
	@GetMapping()
	public ResponseEntity<List<Historico>> listar(){
		System.out.println("Listando Historico de Compra");
		return ResponseEntity.status(HttpStatus.OK).body(histSe.listar());
	}

}
