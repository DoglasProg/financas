package br.com.financas.services;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import br.com.financas.domain.Conta;
import br.com.financas.domain.enumerated.TipoMovimentacaoEnum;

/**
 * Interface de acesso a recursos das movimentaçoes financeiras
 * 
 * @author doglas
 *
 */
@Service
public interface MovimentacaoFinanceiraService extends Serializable{

	/**
	 * Método responsável por cadastrar uma movimentação
	 * 
	 * @param conta - Entidade Conta
	 * @param valor - valor de movimentação
	 * @param tipoMovimentacao - tipo de movimentação
	 */
	void cadastrar(Conta conta, BigDecimal valor, TipoMovimentacaoEnum tipoMovimentacao);

}
