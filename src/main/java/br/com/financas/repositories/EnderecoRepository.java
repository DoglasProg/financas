package br.com.financas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.financas.domain.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

}
