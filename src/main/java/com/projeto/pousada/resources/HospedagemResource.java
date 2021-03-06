package com.projeto.pousada.resources;

import com.projeto.pousada.domain.Categoria;
import com.projeto.pousada.domain.Hospedagem;
import com.projeto.pousada.services.CategoriaService;
import com.projeto.pousada.services.HospedagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (value="/hospedagens")
public class HospedagemResource {

    @Autowired
    private HospedagemService hospedagemService;

    @GetMapping("/{id}")
    public ResponseEntity<?> find(@PathVariable Integer id){
        Hospedagem obj = hospedagemService.find(id);
        return ResponseEntity.ok().body(obj);
    }
}
