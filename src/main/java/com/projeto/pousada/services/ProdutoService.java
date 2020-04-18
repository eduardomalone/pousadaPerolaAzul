package com.projeto.pousada.services;

import com.projeto.pousada.domain.Categoria;
import com.projeto.pousada.domain.Funcionario;
import com.projeto.pousada.domain.Produto;
import com.projeto.pousada.repositories.FuncionarioRepository;
import com.projeto.pousada.repositories.ProdutoRepository;
import com.projeto.pousada.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

        public Produto find(Integer id) {
            Optional<Produto> obj = repository.findById(id);
            return obj.orElseThrow(() -> new ObjectNotFoundException(
                    "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
        }
}
