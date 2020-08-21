package br.com.financas.services.mapper;

import br.com.financas.domain.Conta;
import br.com.financas.domain.dto.ContaDto;
import br.com.financas.domain.enumerated.StatusAtivacaoContaEnum;

/**
 * Mapper responsável por converter o DTO da Camada de Integration da
 * Conta.
 * 
 * @author doglas
 */
public final class ContaMapper {
	
	private ContaMapper() {}
	
	public static Conta mapper(ContaDto contaDto) {
		Conta conta = new Conta();
		conta.setAgencia(contaDto.getAgencia());
		conta.setBanco(contaDto.getBanco());
		conta.setContaAtiva(StatusAtivacaoContaEnum.A);
		conta.setNumeroDaConta(contaDto.getNumeroDaConta());
		conta.setSaldo(contaDto.getSaldo());
		return conta;
	}

}
