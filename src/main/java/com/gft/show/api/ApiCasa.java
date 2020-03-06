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


import com.gft.show.model.CasaShow;
import com.gft.show.service.CasaShowService;

import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "Casa de Show")
@RestController
@RequestMapping("/api/casas")
public class ApiCasa {
	
	@Autowired
	private CasaShowService casaSe;
	
	@ApiOperation("Listar todas as Casas de Show")
	@GetMapping()
	public ResponseEntity<List<CasaShow>> listar(){
		System.out.println("Listando casas de show");
		List<CasaShow> casas = casaSe.listar();
		return ResponseEntity.status(HttpStatus.OK).body(casas);
	
	
	}
	
	@ApiOperation("Listar Casa de Show por nome em ordem DESC")
	@GetMapping("/nome/asc")
	public ResponseEntity<List<CasaShow>> listaASC(){
		System.out.println("Listando casas em ordem ASC");
		List<CasaShow> casas = casaSe.listarAsc();
		return ResponseEntity.status(HttpStatus.OK).body(casas);
		
	}
	
	@ApiOperation("Listar Casa de Show por nome em ordem DESC")
	@GetMapping("/nome/desc")
	public ResponseEntity<List<CasaShow>> listaDESC(){
		System.out.println("Listando casas em ordem ASC");
		List<CasaShow> casas = casaSe.listarDesc();
		return ResponseEntity.status(HttpStatus.OK).body(casas);
		
	}
	
	@ApiOperation("Salvar Casa de Show")
	@PostMapping()
	public ResponseEntity<Void> salvar(@Valid@RequestBody CasaShow casa) {
		System.out.println("Salvei");
		casa = casaSe.salvar(casa, null);
		
		URI uri =ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{codigo}").buildAndExpand(casa.getCodigo()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@ApiOperation("Buscar uma Casa de Show")
	@GetMapping("/{codigo}")
	public ResponseEntity<CasaShow> buscar(@PathVariable("codigo") Long codigo) {
		CasaShow casa = casaSe.buscar(codigo, null);

		
		return ResponseEntity.status(HttpStatus.OK).body(casa);
	}
	
	@ApiOperation("Buscar Casa de Show por nome")
	@GetMapping("/nome/{nome}")
	public ResponseEntity<?> buscarPorNome(@PathVariable("nome") String nome) {
		CasaShow casa = casaSe.buscarPorNome(nome);

		
		return ResponseEntity.status(HttpStatus.OK).body(casa);
	}
	
	
	@ApiOperation("Deletar Casa de Show")
	@DeleteMapping("/{codigo}")
	public ResponseEntity<Void> deletar(@PathVariable("codigo")Long codigo){
		casaSe.deletar(codigo);
		return ResponseEntity.noContent().build();
	}
	
	
	@ApiOperation("Atualizar dados de uma casa de show")
	@PutMapping("/{codigo}")
	public ResponseEntity<Void> altualizar(@Valid @RequestBody CasaShow casa, @PathVariable("codigo") Long codigo) {
		casa.setCodigo(codigo);
		
		casaSe.atualizar(casa);
		
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}
