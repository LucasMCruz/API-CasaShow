package com.gft.show.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gft.show.exceptions.CasaNao;
import com.gft.show.model.CasaShow;
import com.gft.show.repository.CasaShowRepository;

@Service
public class CasaShowService {
	
	@Autowired
	private CasaShowRepository casaRe;
	
	public List<CasaShow>listar(){
		System.out.println("method listar");
		return casaRe.findAll();
	}
	
	public List<CasaShow>listarAsc(){
		System.out.println("Listei em ordem Asc");
		return casaRe.findAll(Sort.by(Sort.Direction.ASC, "nome"));
	}
	
	public List<CasaShow>listarDesc(){
		System.out.println("Listei em ordem Asc");
		return casaRe.findAll(Sort.by(Sort.Direction.DESC, "nome"));
	}
	
	public CasaShow salvar(CasaShow casas, RedirectAttributes attributes) {
		System.out.println("he"+casas.getCodigo());
		if(casas.getCodigo() !=null) {
			Optional<CasaShow> a = casaRe.findById(casas.getCodigo());
		
			if(a.isPresent()) {
				throw new CasaNao("Casa ja eXiste existe");
			}
		}
		
		return casaRe.save(casas);
	}
	
	public CasaShow buscar(Long codigo, RedirectAttributes attributes) {
		CasaShow casa = casaRe.findById(codigo).get();
		
		if(casa == null) {
			throw new CasaNao("Casa Na0 existe");
			}
		return casa;
	}
	
	public CasaShow buscarPorNome(String nome) {
		CasaShow casa = casaRe.findByNome(nome);
		
		if(casa == null) {
			throw new CasaNao("Casa Na0 existe");
			}
		
		return casa;
	}
	
	public void atualizar(CasaShow casas) {
		buscar(casas.getCodigo(), null);
		casaRe.save(casas);
		
	}
	public void deletar(Long codigo) {
		casaRe.deleteById(codigo);
	}
	

}
