package br.com.financas.services.impl;

import static br.com.financas.services.util.MensagemConstanteUtil.CADASTRADO;
import static br.com.financas.services.util.MensagemConstanteUtil.ERRO_CADASTRO_CLIENTE;
import static br.com.financas.services.util.MensagemConstanteUtil.ERRO_CLIENTE_JA_CADASTRADO;
import static br.com.financas.services.util.MensagemConstanteUtil.ERRO_NO_TAMANHO_DO_CPF_CNPJ;
import static br.com.financas.services.util.MensagemConstanteUtil.QUANTIDADE_ZERO;

import java.text.MessageFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.financas.domain.Cliente;
import br.com.financas.domain.dto.CadastroClienteDto;
import br.com.financas.domain.dto.RetornoPadramDto;
import br.com.financas.domain.dto.TransacaoInicialDto;
import br.com.financas.domain.enumerated.TipoDeClienteEnum;
import br.com.financas.domain.enumerated.TipoMovimentacaoEnum;
import br.com.financas.repositories.ClienteRepository;
import br.com.financas.services.ClienteService;
import br.com.financas.services.EnderecoService;
import br.com.financas.services.MovimentacaoFinanceiraService;
import br.com.financas.services.exceptions.AplicacaoException;
import br.com.financas.services.mapper.ClienteMapper;
import br.com.financas.services.mapper.ContaMapper;

@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class ClienteServiceImpl implements ClienteService{

	private static final long serialVersionUID = 1882417162549443796L;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ClienteServiceImpl.class);
	
	private static final int TAMANHO_CPF = 11;
	private static final int TAMANHO_CNPJ = 14;
	
	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private EnderecoService enderecoService;
	
	@Autowired
	private MovimentacaoFinanceiraService movimentacaoFinanceiraService;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public RetornoPadramDto cadastrar(CadastroClienteDto cadastroCliente) {
		
		Cliente cliente;
		
		if(!QUANTIDADE_ZERO.equals(repository.validarClienteJaCadastrado(cadastroCliente.getCpfCnpj()))) {
			throw new AplicacaoException(ERRO_CLIENTE_JA_CADASTRADO);
		}
		
		if(TipoDeClienteEnum.F.toString().equals(cadastroCliente.getTipoPessoa()) && cadastroCliente.getCpfCnpj().length() == TAMANHO_CPF) {
			cliente = ClienteMapper.mapperPessoaFisica(cadastroCliente);
		}else if(TipoDeClienteEnum.J.toString().equals(cadastroCliente.getTipoPessoa()) && cadastroCliente.getCpfCnpj().length() == TAMANHO_CNPJ) {
			cliente = ClienteMapper.mapperPessoaJuridica(cadastroCliente);
		}else {
			LOGGER.error(MessageFormat.format(ERRO_CADASTRO_CLIENTE, cadastroCliente.getCpfCnpj(), cadastroCliente.getTipoPessoa()));
			throw new AplicacaoException(ERRO_NO_TAMANHO_DO_CPF_CNPJ);
		}
		
		cliente.setEndereco(enderecoService.cadastrar(cadastroCliente.getEndereco()));
		cadastroCliente.getContas().stream().forEach(conta -> cliente.adcionarConta(ContaMapper.mapper(conta)));
		
		repository.save(cliente);
		
		TransacaoInicialDto transacao = cadastroCliente.getTransacaoInicial();
		
		cliente.getContas().stream()
				.filter(conta -> conta.getNumeroDaConta().contentEquals(transacao.getNumeroDaConta()))
				.forEach(transConta -> movimentacaoFinanceiraService.cadastrar(transConta, transacao.getDeposito(),
						TipoMovimentacaoEnum.I));		
		
		return new RetornoPadramDto(CADASTRADO, cliente.getId());
	}

}
