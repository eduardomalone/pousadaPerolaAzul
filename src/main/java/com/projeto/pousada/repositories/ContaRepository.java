package com.projeto.pousada.repositories;

import com.projeto.pousada.domain.Aposento;
import com.projeto.pousada.domain.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer> {
}
