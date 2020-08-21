package br.com.financas.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.financas.domain.Endereco;
import br.com.financas.domain.dto.EnderecoDto;
import br.com.financas.repositories.EnderecoRepository;
import br.com.financas.services.EnderecoService;
import br.com.financas.services.mapper.EnderecoMapper;

@Service
public class EnderecoServiceImpl implements EnderecoService{
	
	private static final long serialVersionUID = 4026839428488752204L;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EnderecoServiceImpl.class);
	
	@Autowired
	private EnderecoRepository repository;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Endereco cadastrar(EnderecoDto enderecoDto) {
		return repository.save(EnderecoMapper.mapper(enderecoDto));
	}

}
