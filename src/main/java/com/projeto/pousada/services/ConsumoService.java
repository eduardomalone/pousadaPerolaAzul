package com.projeto.pousada.services;

import com.projeto.pousada.domain.Categoria;
import com.projeto.pousada.domain.Consumo;
import com.projeto.pousada.repositories.CategoriaRepository;
import com.projeto.pousada.repositories.ConsumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConsumoService {

    @Autowired
    private ConsumoRepository repository;

        public Consumo find(Integer id) {
            Optional<Consumo> obj = repository.findById(id);
            return obj.orElse(null);
        }
}
