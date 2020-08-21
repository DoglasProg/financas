package br.com.financas.services;

import java.io.Serializable;

import org.springframework.stereotype.Service;

import br.com.financas.domain.Endereco;
import br.com.financas.domain.dto.EnderecoDto;

/**
 * Interface de acesso a recursos do endereço
 * 
 * @author doglas
 *
 */
@Service
public interface EnderecoService extends Serializable{

	/**
	 * Método responsável por cadastrar um endereço
	 * 
	 * @param enderecoDto - dados do endereço
	 * 
	 * @return {@link Endereco} - entidade endereço
	 */
	Endereco cadastrar(EnderecoDto enderecoDto);

}
