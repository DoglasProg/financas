package br.com.financas.domain.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * DTO com os dados que representa uma transação
 * 
 * @author doglas
 *
 */
public class TransacaoInicialDto implements Serializable {

	private static final long serialVersionUID = -2414399616785303742L;
	
	@NotNull(message = "Número da Conta não pode ser nula.")
	@NotEmpty(message = "Número da Conta não pode ser vazio.")
	private String numeroDaConta;
	
	@NotNull(message = "Agência não pode ser nula.")
	@NotEmpty(message = "Agência não pode ser vazio.")
	private String agencia;
	
	@NotNull(message = "Banco não pode ser nulo.")
	@NotEmpty(message = "Banco não pode ser vazio.")
	private String banco;
	
	@NotNull(message = "Valor de deposito não pode ser nulo.")
	private BigDecimal deposito;

	public String getNumeroDaConta() {
		return numeroDaConta;
	}

	public void setNumeroDaConta(String numeroDaConta) {
		this.numeroDaConta = numeroDaConta;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public BigDecimal getDeposito() {
		return deposito;
	}

	public void setDeposito(BigDecimal deposito) {
		this.deposito = deposito;
	}

}
