package com.gft.show.api;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.gft.show.model.Evento;
import com.gft.show.service.EventoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@Api(tags="Evento")
@RestController
@RequestMapping("/api/eventos")
public class ApiEvento {
	
	@Autowired
	private EventoService eventoSe;
	
	@ApiOperation("Listar todos os Eventos")
	@GetMapping()
	public ResponseEntity<List<Evento>>listar(){
		System.out.println("Listando eventos");
		
		return ResponseEntity.status(HttpStatus.OK).body(eventoSe.listar());
		
	}
	
	@ApiOperation("Listar todos os Eventos em Asc")
	@GetMapping("/valor/asc")
	public ResponseEntity<List<Evento>> listaValorASC(){
		System.out.println("Listando evento em ordem ASC");
		List<Evento> casas = eventoSe.listarValAsc();
		return ResponseEntity.status(HttpStatus.OK).body(casas);
		
	}
	
	@ApiOperation("Listar todos os Eventos em Desc")
	@GetMapping("/valor/desc")
	public ResponseEntity<List<Evento>> listaValorDESC(){
		System.out.println("Listando Evento em ordem ASC");
		List<Evento> casas = eventoSe.listarValDesc();
		return ResponseEntity.status(HttpStatus.OK).body(casas);
		
	}
	
	@ApiOperation("Listar todos os Eventos em Asc")
	@GetMapping("/data/asc")
	public ResponseEntity<List<Evento>> listaDataASC(){
		System.out.println("Listando evento em ordem ASC");
		List<Evento> casas = eventoSe.listarDataAsc();
		return ResponseEntity.status(HttpStatus.OK).body(casas);
		
	}
	
	@ApiOperation("Listar todos os Eventos em Desc")
	@GetMapping("/data/desc")
	public ResponseEntity<List<Evento>> listaDataDESC(){
		System.out.println("Listando Evento em ordem ASC");
		List<Evento> casas = eventoSe.listarDataDesc();
		return ResponseEntity.status(HttpStatus.OK).body(casas);
		
	}
	
	@ApiOperation("Listar todos os Eventos em Asc")
	@GetMapping("/capacidade/asc")
	public ResponseEntity<List<Evento>> listaCapASC(){
		System.out.println("Listando evento em ordem ASC");
		List<Evento> casas = eventoSe.listarCapAsc();
		return ResponseEntity.status(HttpStatus.OK).body(casas);
		
	}
	
	@ApiOperation("Listar todos os Eventos em Desc")
	@GetMapping("/capacidade/desc")
	public ResponseEntity<List<Evento>> listaCapDESC(){
		System.out.println("Listando Evento em ordem ASC");
		List<Evento> casas = eventoSe.listarCapDesc();
		return ResponseEntity.status(HttpStatus.OK).body(casas);
		
	}
	
	@ApiOperation("Listar todos os Eventos em Asc")
	@GetMapping("/nome/asc")
	public ResponseEntity<List<Evento>> listaASC(){
		System.out.println("Listando evento em ordem ASC");
		List<Evento> casas = eventoSe.listarAsc();
		return ResponseEntity.status(HttpStatus.OK).body(casas);
		
	}
	
	@ApiOperation("Listar todos os Eventos em Desc")
	@GetMapping("/nome/desc")
	public ResponseEntity<List<Evento>> listaDESC(){
		System.out.println("Listando Evento em ordem ASC");
		List<Evento> casas = eventoSe.listarDesc();
		return ResponseEntity.status(HttpStatus.OK).body(casas);
		
	}
	
	
	@ApiOperation("Salva um novo Evento")
	@PostMapping()
	public ResponseEntity<Void> salvar(@ApiParam(name="Salvar um novo Evento")@RequestBody  Evento evento){
		System.out.println("Salvei um evento");
		eventoSe.salvar(evento);
		
		URI uri =ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{codigo}").buildAndExpand(evento.getCodigo()).toUri();
		
		return ResponseEntity.created(uri).build();
		 
	}
	
	@ApiOperation("Listar o Evento pelo Id")
	@GetMapping("/{codigo}")
	public ResponseEntity <?> buscar(@PathVariable("codigo") Long codigo){
		Evento evento = eventoSe.buscar(codigo, null);
		
		return ResponseEntity.status(HttpStatus.OK).body(evento);
	}

	@ApiOperation("Alterar os eventos")
	@PutMapping("/{codigo}")
	public ResponseEntity<Void> altualizar(@Valid @RequestBody Evento evento, @PathVariable("codigo") Long codigo) {
		evento.setCodigo(codigo);
		
		eventoSe.atualizar(evento);
		
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	
	@ApiOperation("Salva os livros")
	@DeleteMapping("/{codigo}")
	public ResponseEntity<Void> deletar(@PathVariable("codigo")Long codigo){
		eventoSe.deletar(codigo);
		return ResponseEntity.noContent().build();
	}
	
}








