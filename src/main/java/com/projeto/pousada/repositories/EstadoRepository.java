package com.projeto.pousada.repositories;

import com.projeto.pousada.domain.Cidade;
import com.projeto.pousada.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {
}
