package com.projeto.pousada.repositories;

import com.projeto.pousada.domain.Cliente;
import com.projeto.pousada.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
