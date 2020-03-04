package com.gft.show.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.show.model.Historico;
import com.gft.show.repository.HistoricoRepository;

@Service
public class HistoricoService {
	
	@Autowired
	private HistoricoRepository histRe;
	
	public List<Historico> listar(){
		return histRe.findAll();
	}
	
	

}
