package br.com.financas.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.financas.domain.Conta;
import br.com.financas.domain.dto.ContaDto;
import br.com.financas.repositories.ContaRepository;
import br.com.financas.services.ContaService;
import br.com.financas.services.mapper.ContaMapper;

@Service
public class ContaServiceImpl implements ContaService{
	
	private static final long serialVersionUID = -2830021771597940519L;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ContaServiceImpl.class);
	
	@Autowired
	private ContaRepository repository;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Conta cadastrar(ContaDto contaDto) {
		return repository.save(ContaMapper.mapper(contaDto));
	}
	
}
