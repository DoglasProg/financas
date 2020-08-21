package br.com.financas.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="endereco", schema = "system")
@SequenceGenerator(schema = "system", name = "seq_endereco", sequenceName = "seq_endereco", allocationSize = 1)
public class Endereco implements Serializable{
	
	private static final long serialVersionUID = -6532442070342878526L;

	@Id
	@Column(name = "id_endereco")
	@GeneratedValue(generator =  "seq_produto", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@NotNull
	@Size(max = 100)
	@Column(name = "rua")
	private String rua;
	
	@NotNull
	@Size(max = 5)
	@Column(name = "numero")
	private String numero;
	
	@NotNull
	@Size(max = 100)
	@Column(name = "complemento")
	private String complemento;
	
	@NotNull
	@Size(max = 50)
	@Column(name = "bairro")
	private String bairro;
	
	@NotNull
	@Size(max = 50)
	@Column(name = "cidade")
	private String cidade;
	
	@NotNull
	@Size(max = 2)
	@Column(name = "uf")
	private String uf;
	
	@NotNull
	@Size(max = 9)
	@Column(name = "cep")
	private String cep;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
		Endereco other = (Endereco) obj;
		return Objects.equals(id, other.id);
	}

}
