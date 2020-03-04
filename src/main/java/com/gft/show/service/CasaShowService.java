package com.gft.show.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	public CasaShow salvar(CasaShow casas, RedirectAttributes attributes) {
		System.out.println("he"+casas.getCodigo());
		if(casas.getCodigo() !=null) {
			Optional<CasaShow> a = casaRe.findById(casas.getCodigo());
		
			if(a.isPresent()) {
				attributes.addFlashAttribute("mensagem", "CAsa ja existe");
			}
		}
		
		return casaRe.save(casas);
	}
	
	public CasaShow buscar(Long codigo, RedirectAttributes attributes) {
		CasaShow casa = casaRe.findById(codigo).get();
		
		if(casa == null) {
			attributes.addFlashAttribute("mensagem", "CAsa nao existe");
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
