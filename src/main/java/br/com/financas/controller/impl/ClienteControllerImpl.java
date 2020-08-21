package br.com.financas.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.financas.controller.ClienteController;
import br.com.financas.domain.dto.CadastroClienteDto;
import br.com.financas.domain.dto.RetornoPadramDto;
import br.com.financas.services.ClienteService;


@RestController
@RequestMapping("clientes")
public class ClienteControllerImpl implements ClienteController{

	private static final long serialVersionUID = 7280061310562761826L;
	
	@Autowired
	private ClienteService service;
	
	@Override
	public RetornoPadramDto cadastrar(CadastroClienteDto cadastroCliente) {
		return service.cadastrar(cadastroCliente);
	}

}
