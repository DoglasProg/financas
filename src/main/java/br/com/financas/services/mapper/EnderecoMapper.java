package br.com.financas.services.mapper;

import br.com.financas.domain.Endereco;
import br.com.financas.domain.dto.EnderecoDto;

/**
 * Mapper responsável por converter o DTO da Camada de Integration do
 * Endereço.
 * 
 * @author doglas
 */
public final class EnderecoMapper {
	
	private EnderecoMapper() {}
	
	public static Endereco mapper(EnderecoDto enderecoDto) {
		Endereco endereco = new Endereco();
		endereco.setBairro(enderecoDto.getBairro());
		endereco.setCep(enderecoDto.getCep());
		endereco.setCidade(enderecoDto.getCidade());
		endereco.setComplemento(enderecoDto.getComplemento());
		endereco.setNumero(enderecoDto.getNumero());
		endereco.setRua(enderecoDto.getRua());
		endereco.setUf(enderecoDto.getUf());
		return endereco;
	}

}
