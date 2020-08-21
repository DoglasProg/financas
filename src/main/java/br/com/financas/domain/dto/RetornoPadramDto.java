package br.com.financas.domain.dto;

import java.io.Serializable;

/**
 * DTO para ser utilizado quando existe a necessidade
 * de passar uma mensagem de feedback da ação e um payload (ex: id da entidade criada)
 * 
 * @author doglas
 *
 */
public class RetornoPadramDto implements Serializable {

	private static final long serialVersionUID = 8584080386226713937L;

	private String mensagem;

	private Serializable payload;

	public RetornoPadramDto(String mensagem) {
		this.mensagem = mensagem;
	}

	public RetornoPadramDto(String mensagem, Serializable payload) {
		this.mensagem = mensagem;
		this.payload = payload;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Serializable getPayload() {
		return payload;
	}

	public void setPayload(Serializable payload) {
		this.payload = payload;
	}
	
	

}
