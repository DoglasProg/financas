package br.com.financas.services.exceptions.handler;

/**
 * DTO com os dados de erro na validação de formulários
 * 
 * @author doglas
 *
 */
public class ErroDeFormularioDto {
	
	private String campo;
	private String erro;
	
	public ErroDeFormularioDto(String campo, String erro) {
		this.campo = campo;
		this.erro = erro;
	}

	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}

}
