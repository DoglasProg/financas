package br.com.financas.services.impl;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.financas.domain.Conta;
import br.com.financas.domain.enumerated.TipoMovimentacaoEnum;
import br.com.financas.repositories.MovimentacaoFinanceiraRepository;
import br.com.financas.services.MovimentacaoFinanceiraService;
import br.com.financas.services.mapper.MovimentacaoFinanceiraMapper;

@Service
public class MovimentacaoFinanceiraServiceImpl implements MovimentacaoFinanceiraService{

	private static final long serialVersionUID = 6680748871057572346L;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MovimentacaoFinanceiraServiceImpl.class);
	
	@Autowired
	private MovimentacaoFinanceiraRepository repository;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void cadastrar(Conta conta, BigDecimal valor, TipoMovimentacaoEnum tipoMovimentacao) {
		repository.save(MovimentacaoFinanceiraMapper.mapper(conta, valor, tipoMovimentacao));
	}

}
