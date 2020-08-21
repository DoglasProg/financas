package br.com.financas.services.mapper;

import java.time.LocalDate;

import br.com.financas.domain.PessoaFisica;
import br.com.financas.domain.PessoaJuridica;
import br.com.financas.domain.dto.CadastroClienteDto;

/**
 * Mapper responsável por converter o DTO da Camada de Integration do
 * Cliente.
 * 
 * @author doglas
 */
public final class ClienteMapper {
	
	private ClienteMapper() {}
	
	public static PessoaFisica mapperPessoaFisica(CadastroClienteDto cadastroCliente) {
		PessoaFisica pessoaFisica = new PessoaFisica();
		pessoaFisica.setNome(cadastroCliente.getNome());
		pessoaFisica.setEmail(cadastroCliente.getEmail());
		pessoaFisica.setNumeroTelefone(cadastroCliente.getNumeroTelefone());
		pessoaFisica.setDdd(cadastroCliente.getDdd());
		pessoaFisica.setCpf(cadastroCliente.getCpfCnpj());
		pessoaFisica.setDataDeCadastro(LocalDate.now());
		return pessoaFisica;
	}
	
	public static PessoaJuridica mapperPessoaJuridica(CadastroClienteDto cadastroCliente) {
		PessoaJuridica pessoaJuridica = new PessoaJuridica();
		pessoaJuridica.setNome(cadastroCliente.getNome());
		pessoaJuridica.setEmail(cadastroCliente.getEmail());
		pessoaJuridica.setNumeroTelefone(cadastroCliente.getNumeroTelefone());
		pessoaJuridica.setDdd(cadastroCliente.getDdd());
		pessoaJuridica.setCnpj(cadastroCliente.getCpfCnpj());
		pessoaJuridica.setDataDeCadastro(LocalDate.now());
		return pessoaJuridica;
	}

}
