package br.com.financas.services.mapper;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.financas.domain.Conta;
import br.com.financas.domain.MovimentacaoFinanceira;
import br.com.financas.domain.enumerated.TipoMovimentacaoEnum;

/**
 * Mapper responsável por converter o DTO da Camada de Integration da
 * Movimentação Financeira.
 * 
 * @author doglas
 */
public final class MovimentacaoFinanceiraMapper {

	private MovimentacaoFinanceiraMapper() {}
	
	public static MovimentacaoFinanceira mapper(Conta conta, BigDecimal valor, TipoMovimentacaoEnum tipoMovimentacao) {
		MovimentacaoFinanceira movimentacao = new MovimentacaoFinanceira();
		movimentacao.setDataDaMovimentacao(LocalDate.now());
		movimentacao.setTipoMovimentacao(tipoMovimentacao);
		movimentacao.setValorMovimentacao(valor);
		movimentacao.setConta(conta);
		return movimentacao;
	}
}
