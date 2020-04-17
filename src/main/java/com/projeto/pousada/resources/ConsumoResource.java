package com.projeto.pousada.resources;

import com.projeto.pousada.domain.Consumo;
import com.projeto.pousada.domain.Funcionario;
import com.projeto.pousada.services.ConsumoService;
import com.projeto.pousada.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (value="/consumo")
public class ConsumoResource {

    @Autowired
    private ConsumoService consumoService;

    @GetMapping("/{id}")
    public ResponseEntity<?> find(@PathVariable Integer id){
        Consumo obj = consumoService.find(id);
        return ResponseEntity.ok().body(obj);
    }
}
