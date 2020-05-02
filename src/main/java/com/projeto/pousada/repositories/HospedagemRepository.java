package com.projeto.pousada.repositories;

import com.projeto.pousada.domain.Categoria;
import com.projeto.pousada.domain.Hospedagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospedagemRepository extends JpaRepository<Hospedagem, Integer> {
}
