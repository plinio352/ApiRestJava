package br.com.pps.ApiRestJava.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.com.pps.ApiRestJava.dto.request.ContaDTO;
import br.com.pps.ApiRestJava.modelo.Conta;

@Mapper
public interface ContaMapper {

	ContaMapper INSTANCE = Mappers.getMapper(ContaMapper.class);
	
	@Mapping(target = "data", source = "data", dateFormat = "dd-MM-yyyy")
	Conta toConta(ContaDTO contaDTO);
	
	ContaDTO toContaDTO(Conta conta);
}
