package br.com.pps.ApiRestJava.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.pps.ApiRestJava.enums.DescricaoType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="contas")
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private long id;

	@NotBlank(message = "* Preencha o campo Descrição!")	
	@Enumerated(EnumType.STRING)
	@Column(name="descricao")	
	private DescricaoType descricao;
	
	@DecimalMin(value="1", message = "* Preencha o campo valor no minimo 1.00!")
	@Column(name="valor")
	private double valor;
	
	@NotNull(message = "* Preencha o campo data!")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name="data")	
	private Date data;
	
	@NotEmpty(message="* Preencha o campo Categoria!")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_categoria", referencedColumnName= "id")
	private Categoria categoria;

}
