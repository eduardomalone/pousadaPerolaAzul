package com.projeto.pousada.repositories;

import com.projeto.pousada.domain.Consumo;
import com.projeto.pousada.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumoRepository extends JpaRepository<Consumo, Integer> {
}
