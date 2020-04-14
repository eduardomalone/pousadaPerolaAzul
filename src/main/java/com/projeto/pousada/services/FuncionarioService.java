package com.projeto.pousada.services;

import com.projeto.pousada.domain.Funcionario;
import com.projeto.pousada.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

        public Funcionario find(Integer id) {
            Optional<Funcionario> obj = repository.findById(id);
            return obj.orElse(null);
        }
}
