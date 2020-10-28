package br.com.pps.ApiRestJava.dto.request;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDTO {

	private long id;

	@NotBlank(message="* Preencha o campo Nome!")
	private String nome;
	
}
