package br.com.pps.ApiRestJava.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ContaNotFoundException extends Exception {

	public ContaNotFoundException(long id) {
		
		super("Conta não existe para ID: "+ id);
	}
}
