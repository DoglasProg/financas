package br.com.financas.services;

import java.io.Serializable;

import org.springframework.stereotype.Service;

import br.com.financas.domain.Conta;
import br.com.financas.domain.dto.ContaDto;

/**
 * Interface de acesso a recursos das contas
 * 
 * @author doglas
 *
 */
@Service
public interface ContaService extends Serializable{

	/**
	 * Método responsável por cadastrar uma conta
	 * 
	 * @param contaDto - DTO com dados da conta
	 * 
	 * @return {@link Conta} - entidade Conta
	 */
	Conta cadastrar(ContaDto contaDto);

}
