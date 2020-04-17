package com.projeto.pousada.resources;

import com.projeto.pousada.domain.Funcionario;
import com.projeto.pousada.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping (value="/funcionario")
public class FuncionariosResource {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping("/{id}")
    public ResponseEntity<?> find(@PathVariable Integer id){
        Funcionario obj = funcionarioService.find(id);
        return ResponseEntity.ok().body(obj);
    }
}
