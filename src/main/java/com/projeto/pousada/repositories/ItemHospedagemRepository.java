package com.projeto.pousada.repositories;

import com.projeto.pousada.domain.Aposento;
import com.projeto.pousada.domain.ItemHospedagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemHospedagemRepository extends JpaRepository<ItemHospedagem, Integer> {
}
