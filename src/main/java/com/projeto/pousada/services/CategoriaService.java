package com.projeto.pousada.services;

import com.projeto.pousada.domain.Categoria;
import com.projeto.pousada.domain.Produto;
import com.projeto.pousada.repositories.CategoriaRepository;
import com.projeto.pousada.repositories.ProdutoRepository;
import com.projeto.pousada.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

        public Categoria find(Integer id) {
            Optional<Categoria> obj = repository.findById(id);
            return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
        }

        public Categoria insert(Categoria obj){
            obj.setId(null);
            return  repository.save(obj);
        }
}
