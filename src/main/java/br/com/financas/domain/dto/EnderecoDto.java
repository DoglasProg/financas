package br.com.financas.domain.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * DTO com os dados que representa um endereço
 * 
 * @author doglas
 *
 */
public class EnderecoDto implements Serializable {

	private static final long serialVersionUID = 3936691729233820858L;

	@NotNull(message = "Nome da rua não pode ser nulo.")
	@NotEmpty(message = "Nome da rua não pode ser vazio.")
	@Size(max = 100)
	private String rua;
	
	@NotNull(message = "Número da rua não pode ser nulo.")
	@NotEmpty(message = "Número da rua não pode ser vazio.")
	@Size(max = 5)
	private String numero;
	
	@NotNull(message = "Complemento não pode ser nulo.")
	@NotEmpty(message = "Complemento não pode ser vazio.")
	@Size(max = 100)
	private String complemento;
	
	@NotNull(message = "Bairro não pode ser nulo.")
	@NotEmpty(message = "Bairro não pode ser vazio.")
	@Size(max = 50)
	private String bairro;
	
	@NotNull(message = "Cidade não pode ser nulo.")
	@NotEmpty(message = "Cidade não pode ser vazio.")
	@Size(max = 50)
	private String cidade;
	
	@NotNull(message = "UF não pode ser nulo.")
	@NotEmpty(message = "UF não pode ser vazio.")
	@Size(max = 2)
	private String uf;
	
	@NotNull(message = "cep não pode ser nulo.")
	@NotEmpty(message = "cep não pode ser vazio.")
	@Size(max = 9)
	private String cep;

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

}
