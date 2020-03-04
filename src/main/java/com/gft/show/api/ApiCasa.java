package com.gft.show.api;

import java.net.URI;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import com.gft.show.model.CasaShow;
import com.gft.show.model.Evento;
import com.gft.show.repository.CasaShowRepository;
import com.gft.show.service.CasaShowService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;

@Api(tags = "Casa de Show")
@RestController
@RequestMapping("/api/casas")
public class ApiCasa {
	
	@Autowired
	private CasaShowService casaSe;
	
	@GetMapping()
	public ResponseEntity<List<CasaShow>> listar(){
		System.out.println("Listando casas de show");
		List<CasaShow> casas = casaSe.listar();
		return ResponseEntity.status(HttpStatus.OK).body(casas);
		
	}
	@PostMapping()
	public ResponseEntity<Void> salvar(@Valid@RequestBody CasaShow casa) {
		System.out.println("Salvei");
		casa = casaSe.salvar(casa, null);
		
		URI uri =ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{codigo}").buildAndExpand(casa.getCodigo()).toUri();
		return ResponseEntity.created(uri).build();
	}
	@GetMapping("/{codigo}")
	public ResponseEntity<CasaShow> buscar(@PathVariable("codigo") Long codigo) {
		CasaShow casa = casaSe.buscar(codigo, null);

		
		return ResponseEntity.status(HttpStatus.OK).body(casa);
	}
	
	@DeleteMapping("/{codigo}")
	public ResponseEntity<Void> deletar(@PathVariable("codigo")Long codigo){
		casaSe.deletar(codigo);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<Void> altualizar(@Valid @RequestBody CasaShow casa, @PathVariable("codigo") Long codigo) {
		casa.setCodigo(codigo);
		
		casaSe.atualizar(casa);
		
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}
