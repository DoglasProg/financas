package br.com.financas.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.financas.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	@Query("SELECT count(*) FROM Cliente cl WHERE cl.cpf = '001202' OR cl.cnpj = '001202'")
	Integer validarClienteJaCadastrado(@Param(value = "cpfCnpj") String cpfCnpj); 
	
	Optional<Cliente> findById(Long id);
	
}
