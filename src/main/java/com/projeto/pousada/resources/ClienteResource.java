package com.projeto.pousada.resources;

import com.projeto.pousada.domain.Categoria;
import com.projeto.pousada.domain.Cliente;
import com.projeto.pousada.services.CategoriaService;
import com.projeto.pousada.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (value="/cliente")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/{id}")
    public ResponseEntity<?> find(@PathVariable Integer id){
        Cliente obj = clienteService.find(id);
        return ResponseEntity.ok().body(obj);
    }
}
