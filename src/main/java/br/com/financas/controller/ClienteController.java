package br.com.financas.controller;

import java.io.Serializable;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.financas.domain.dto.CadastroClienteDto;
import br.com.financas.domain.dto.RetornoPadramDto;

@RequestMapping("clientes")
public interface ClienteController extends Serializable{
	
	@PostMapping(consumes = "application/json", produces = "application/json")
	RetornoPadramDto cadastrar(@RequestBody @Valid  CadastroClienteDto cadastroCliente);

}
