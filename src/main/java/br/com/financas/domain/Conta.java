package br.com.financas.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.financas.domain.enumerated.StatusAtivacaoContaEnum;

@Entity
@Table(name="conta", schema = "system")
@SequenceGenerator(schema = "system", name = "seq_conta", sequenceName = "seq_conta", allocationSize = 1)
public class Conta implements Serializable{
	
	private static final long serialVersionUID = -4342668111007603563L;

	@Id
	@Column(name = "id_conta")
	@GeneratedValue(generator =  "seq_conta", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@NotNull
	@Column(name = "banco")
	private String banco;
	
	@NotNull
	@Column(name = "agencia")
	private String agencia;
	
	@NotNull
	@Column(name = "numero_conta")
	private String numeroDaConta;
	
	@NotNull
	@Column(name="saldo")
	private BigDecimal saldo;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name= "id_cliente")
	private Cliente cliente;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "conta_ativa")
	private StatusAtivacaoContaEnum contaAtiva;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public StatusAtivacaoContaEnum getContaAtiva() {
		return contaAtiva;
	}

	public void setContaAtiva(StatusAtivacaoContaEnum contaAtiva) {
		this.contaAtiva = contaAtiva;
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		return Objects.equals(id, other.id);
	}

}
