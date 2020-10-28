package br.com.pps.ApiRestJava.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DescricaoType {

	Condominio ("Condominio"),
	Luz ("Luz"),
	Alimentacao ("Alimentacao");
	
	private final String descricao;

}
