package br.com.financas.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
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

import br.com.financas.domain.enumerated.TipoMovimentacaoEnum;

@Entity
@Table(name="movimentacao_financeira", schema = "system")
@SequenceGenerator(schema = "system", name = "seq_movimentacao_financeira", sequenceName = "seq_movimentacao_financeira", allocationSize = 1)
public class MovimentacaoFinanceira implements Serializable{
	
	private static final long serialVersionUID = -1626038681665293222L;

	@Id
	@Column(name = "id_movimentacao")
	@GeneratedValue(generator =  "seq_movimentacao_financeira", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_movimentacao")
	private TipoMovimentacaoEnum tipoMovimentacao;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name= "id_conta")
	private Conta conta;
	
	@NotNull
	@Column(name = "valor_movimentado")
	private BigDecimal valorMovimentacao;
	
	@Column(name = "data_movimentacao")
	private LocalDate dataDaMovimentacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoMovimentacaoEnum getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	public void setTipoMovimentacao(TipoMovimentacaoEnum tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public LocalDate getDataDaMovimentacao() {
		return dataDaMovimentacao;
	}

	public void setDataDaMovimentacao(LocalDate dataDaMovimentacao) {
		this.dataDaMovimentacao = dataDaMovimentacao;
	}

	public BigDecimal getValorMovimentacao() {
		return valorMovimentacao;
	}

	public void setValorMovimentacao(BigDecimal valorMovimentacao) {
		this.valorMovimentacao = valorMovimentacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, valorMovimentacao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovimentacaoFinanceira other = (MovimentacaoFinanceira) obj;
		return Objects.equals(id, other.id) && Objects.equals(valorMovimentacao, other.valorMovimentacao);
	}
	
}
