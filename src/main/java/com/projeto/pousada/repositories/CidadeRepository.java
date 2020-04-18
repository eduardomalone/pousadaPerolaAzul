package com.projeto.pousada.repositories;

import com.projeto.pousada.domain.Categoria;
import com.projeto.pousada.domain.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
}
