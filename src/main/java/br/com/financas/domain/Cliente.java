package br.com.financas.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cliente", schema = "system")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("C")
@DiscriminatorColumn(name = "tipo", length = 1, discriminatorType = DiscriminatorType.STRING)
@SequenceGenerator(schema = "system", name = "seq_cliente", sequenceName = "seq_cliente", allocationSize = 1)
public class Cliente implements Serializable {

	private static final long serialVersionUID = -6868271470762286583L;

	@Id
	@Column(name = "id_cliente")
	@GeneratedValue(generator = "seq_cliente", strategy = GenerationType.SEQUENCE)
	private Long id;

	@NotNull
	@Size(max = 100)
	@Column(name = "nome")
	private String nome;

	@NotNull
	@Column(name = "telefone")
	private Long numeroTelefone;
	
	@NotNull
	@Column(name = "ddd")
	private Integer ddd;

	@NotNull
	@Size(max = 50)
	@Column(name = "email")
	private String email;

	@NotNull
	@Column(name = "data_cadastro")
	private LocalDate dataDeCadastro;

	@Column(name = "tipo", insertable = false, updatable = false)
	private String tipo;

	@OneToMany(mappedBy = "cliente", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	private Set<Conta> contas = new HashSet<>();

	@ManyToOne
	@JoinColumn(name = "id_endereco")
	private Endereco endereco;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Conta> getContas() {
		return contas;
	}

	public void adcionarConta(Conta conta) {
		conta.setCliente(this);
		this.contas.add(conta);
	}

	public void removerConta(Conta conta) {
		conta.setCliente(null);
		this.contas.remove(conta);
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataDeCadastro() {
		return dataDeCadastro;
	}

	public void setDataDeCadastro(LocalDate dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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
		Cliente other = (Cliente) obj;
		return Objects.equals(id, other.id);
	}

}
