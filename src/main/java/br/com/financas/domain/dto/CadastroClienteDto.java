package br.com.financas.domain.dto;

import java.io.Serializable;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.financas.controller.validator.annotation.CpfCnpj;
import br.com.financas.controller.validator.annotation.EnumValues;
import br.com.financas.domain.enumerated.TipoDeClienteEnum;

/**
 * DTO com os dados que representa um cadastro de cliente
 * 
 * @author doglas
 *
 */
public class CadastroClienteDto implements Serializable {

	private static final long serialVersionUID = 2925708433846097652L;

	@NotNull(message = "Nome do usuário não pode ser nulo.")
	@NotEmpty(message = "Nome do usuário não pode ser vazio.")
	@Size(max = 100)
	private String nome;
	
	@NotEmpty(message = "CPF/CNPJ é obrigatório")
	@CpfCnpj(message = "CPF/CNPJ invalidos")
	private String cpfCnpj;
	
	@NotNull(message = "Número do telefone não pode ser nulo.")
	private Long numeroTelefone;
	
	@NotNull(message = "DDD não pode ser nulo.")
	private Integer ddd;
	
	@Email(message = "Email com formato inválido.")
	private String email;
	
	@EnumValues(enumClass = TipoDeClienteEnum.class, acceptNull = false, message = "Tipo de Pessoa não é valida.")
	private String tipoPessoa;
	
	@Valid
	@NotEmpty
	private Set<ContaDto> contas;
	
	@Valid
	@NotNull
	private EnderecoDto endereco;
	
	@Valid
	@NotNull
	private TransacaoInicialDto transacaoInicial;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}


	public String getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public Set<ContaDto> getContas() {
		return contas;
	}

	public void setContas(Set<ContaDto> contas) {
		this.contas = contas;
	}

	public EnderecoDto getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDto endereco) {
		this.endereco = endereco;
	}

	public TransacaoInicialDto getTransacaoInicial() {
		return transacaoInicial;
	}

	public void setTransacaoInicial(TransacaoInicialDto transacaoInicial) {
		this.transacaoInicial = transacaoInicial;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(Long numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	public Integer getDdd() {
		return ddd;
	}

	public void setDdd(Integer ddd) {
		this.ddd = ddd;
	}

}
