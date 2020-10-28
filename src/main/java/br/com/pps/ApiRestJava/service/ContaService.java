package br.com.pps.ApiRestJava.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pps.ApiRestJava.dto.response.MessageResponseDto;
import br.com.pps.ApiRestJava.exception.ContaNotFoundException;
import br.com.pps.ApiRestJava.modelo.Conta;
import br.com.pps.ApiRestJava.repository.ContaRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor=@__(@Autowired))
public class ContaService {

//	private final ContaMapper contaMapper = ContaMapper.INSTANCE;

	private ContaRepository ctaRep;
	
	public Conta findById(long id) throws ContaNotFoundException {
		
		Conta conta = verifyIfExists(id);
		
		return conta;
	}
	
	public MessageResponseDto createConta(Conta conta) {

		Conta contaSave = this.ctaRep.save(conta);
				
		return this.createMessageResponse(contaSave.getId(), "Created conta with ID: ");
	}

	public List<Conta> listaAll() {
		
		List<Conta> allCta = this.ctaRep.findAll();

		return allCta.stream().collect(Collectors.toList());
		
	}

	public void delete(long id) throws ContaNotFoundException {
		 
		verifyIfExists(id);
		
		this.ctaRep.deleteById(id);
	}

	public MessageResponseDto updateById(long id, Conta conta) throws ContaNotFoundException {
		 
		verifyIfExists(id);
		
		Conta contaUpdate = this.ctaRep.save(conta);
		
		return this.createMessageResponse(contaUpdate.getId(), "Updated conta with ID: ");
	}

	private Conta verifyIfExists(long id) throws ContaNotFoundException {
		
		return this.ctaRep.findById(id)
				.orElseThrow(() -> new ContaNotFoundException(id));
	}
	
	private MessageResponseDto createMessageResponse(long id, String message) {
		
		return MessageResponseDto
				.builder()
				.message(message + id)
				.build();
	}
	
	
}
