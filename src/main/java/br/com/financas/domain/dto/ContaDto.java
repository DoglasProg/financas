package br.com.financas.domain.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * DTO com os dados relacionados a contas
 * 
 * @author doglas
 *
 */
public class ContaDto implements Serializable {

	private static final long serialVersionUID = 922488289011271959L;

	@NotNull(message = "Banco não pode ser nulo.")
	@NotEmpty(message = "Banco não pode ser vazio.")
	private String banco;
	
	@NotNull(message = "Agência não pode ser nula.")
	@NotEmpty(message = "Agência não pode ser vazio.")
	private String agencia;
	
	@NotNull(message = "Número da Conta não pode ser nula.")
	@NotEmpty(message = "Número da Conta não pode ser vazio.")
	private String numeroDaConta;
	
	@NotNull(message = "Saldo não pode ser nulo.")
	private BigDecimal saldo;

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getNumeroDaConta() {
		return numeroDaConta;
	}

	public void setNumeroDaConta(String numeroDaConta) {
		this.numeroDaConta = numeroDaConta;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

}
