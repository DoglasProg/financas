package br.com.financas.services.exceptions.handler;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.financas.services.exceptions.AplicacaoException;

@RestControllerAdvice
public class ErroAplicacaoHandler {
	
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(AplicacaoException.class)
	public List<String> handle(AplicacaoException exception) {
		return exception.getMensagens();
	}

}
