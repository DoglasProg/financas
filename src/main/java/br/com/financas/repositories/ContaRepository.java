package br.com.financas.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.financas.domain.Conta;
import br.com.financas.domain.dto.ConsultaContaDto;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long>{
	
	@Query("SELECT NEW br.com.financas.domain.dto.ConsultaContaDto(c.banco, c.agencia, c.numeroDaConta, c.saldo) FROM Conta c WHERE c.id = :idConta")
	Optional<ConsultaContaDto> consultarContaPorId(@Param(value = "idConta") Long idConta);

}
