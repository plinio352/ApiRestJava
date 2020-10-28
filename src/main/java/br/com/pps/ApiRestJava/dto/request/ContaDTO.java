package br.com.pps.ApiRestJava.dto.request;

import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.pps.ApiRestJava.enums.DescricaoType;
import br.com.pps.ApiRestJava.modelo.Categoria;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContaDTO {

	private long id;
	
	@NotBlank(message = "* Preencha o campo Descrição!")
	@Enumerated(EnumType.STRING)
	private DescricaoType descricao;
	
	@DecimalMin(value="1", message = "* Preencha o campo valor no minimo 1.00!")
	private double valor;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@NotNull(message = "* Preencha o campo data!")
	private Date data;
	
//	@Valid
	@NotEmpty(message="* Preencha o campo Categoria!")
	private Categoria categoria;
	
}
