package com.projeto.pousada.services;

import com.projeto.pousada.domain.Categoria;
import com.projeto.pousada.domain.Hospedagem;
import com.projeto.pousada.repositories.CategoriaRepository;
import com.projeto.pousada.repositories.HospedagemRepository;
import com.projeto.pousada.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HospedagemService {

    @Autowired
    private HospedagemRepository repository;

        public Hospedagem find(Integer id) {
            Optional<Hospedagem> obj = repository.findById(id);
            return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
        }
}
