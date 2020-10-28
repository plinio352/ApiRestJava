package br.com.pps.ApiRestJava.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.pps.ApiRestJava.dto.response.MessageResponseDto;
import br.com.pps.ApiRestJava.exception.ContaNotFoundException;
import br.com.pps.ApiRestJava.modelo.Conta;
import br.com.pps.ApiRestJava.service.ContaService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/contas")
@AllArgsConstructor(onConstructor=@__(@Autowired))
public class PersonController {

	private ContaService ctaSev;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDto createConta(@RequestBody @Valid Conta conta) {
		
		return this.ctaSev.createConta(conta);
	}

	@GetMapping
	public List<Conta> listaAll(){
		
		return ctaSev.listaAll(); 
	}
	
	@GetMapping("/{id}")
	public Conta findById (@PathVariable long id) throws ContaNotFoundException {
		
		return this.ctaSev.findById(id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable long id) throws ContaNotFoundException {
		
		this.ctaSev.delete(id);
	}


	@PutMapping("/{id}")
	public MessageResponseDto updateById(@PathVariable long id, @RequestBody @Valid Conta conta) throws ContaNotFoundException {
		
		return this.ctaSev.updateById(id, conta);
	}
	@GetMapping("/teste")
	public String Teste(){
		String result = "{\"id\": 5, \"descricao\": \"Alimentacao\", \"valor\": 35.86, \"data\": \"2022-04-10T00:00:00.000+00:00\", \"categoria\": {\"id\": 1, \"nome\": \"Casa\"}}";
		return result;
		
	}
	
	
}
