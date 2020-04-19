package com.projeto.pousada.repositories;

import com.projeto.pousada.domain.Categoria;
import com.projeto.pousada.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
}
