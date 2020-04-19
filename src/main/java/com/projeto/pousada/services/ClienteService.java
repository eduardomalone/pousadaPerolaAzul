package com.projeto.pousada.services;

import com.projeto.pousada.domain.Categoria;
import com.projeto.pousada.domain.Cliente;
import com.projeto.pousada.repositories.CategoriaRepository;
import com.projeto.pousada.repositories.ClienteRepository;
import com.projeto.pousada.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

        public Cliente find(Integer id) {
            Optional<Cliente> obj = repository.findById(id);
            return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
        }
}
