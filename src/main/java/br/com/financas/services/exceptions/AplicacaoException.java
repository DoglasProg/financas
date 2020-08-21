package br.com.financas.services.exceptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Exceção padrão para a camada de serviço da aplicação
 * 
 * @author doglas
 *
 */
public class AplicacaoException extends RuntimeException {

	private static final long serialVersionUID = 3646253550197498478L;

	private final transient List<String> mensagens = new ArrayList<>();
	
	public AplicacaoException(String... messages) {
		this.mensagens.addAll(Arrays.asList(messages));
	}

	public List<String> getMensagens() {
		return mensagens;
	}

}
