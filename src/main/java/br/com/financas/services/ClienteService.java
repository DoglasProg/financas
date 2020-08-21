package br.com.financas.services;

import java.io.Serializable;

import br.com.financas.domain.dto.CadastroClienteDto;
import br.com.financas.domain.dto.RetornoPadramDto;

/**
 * Interface de acesso a recursos do cliente
 * 
 * @author doglas
 *
 */
public interface ClienteService extends Serializable{

	/**
	 * @author doglas
	 * 
	 * Método responsável por cadastrar um novo Cliente
	 * 
	 * @param cadastroCliente - DTO com os dados do cadastro
	 * 
	 * @return {@link RetornoPadramDto} - retorno padrão do sistema em caso de sucesso
	 */
	RetornoPadramDto cadastrar(CadastroClienteDto cadastroCliente);

}
