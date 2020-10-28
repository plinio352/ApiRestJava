package br.com.pps.ApiRestJava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.pps.ApiRestJava.modelo.Categoria;
import br.com.pps.ApiRestJava.repository.CategoriaRepository;

public class CategoriaService {

	@Autowired
	private CategoriaRepository catRep;
	
	public List<Categoria> lstAll() {
		
		return this.catRep.findAll();
	}
}
