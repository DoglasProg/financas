package br.com.financas.domain.dto;

import java.math.BigDecimal;

/**
 * Dto com os dados de consulta por uma conta
 * 
 * @author doglas
 *
 */
public class ConsultaContaDto {

	private String banco;
	private String agencia;
	private String numeroDaConta;
	private BigDecimal saldo;
	
	public ConsultaContaDto() {
	}

	public ConsultaContaDto(String banco, String agencia, String numeroDaConta, BigDecimal saldo) {
		this.banco = banco;
		this.agencia = agencia;
		this.numeroDaConta = numeroDaConta;
		this.saldo = saldo;
	}

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
