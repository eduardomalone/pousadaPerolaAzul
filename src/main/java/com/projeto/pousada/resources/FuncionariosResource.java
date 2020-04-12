package com.projeto.pousada.resources;

import com.projeto.pousada.domain.Funcionario;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping (value="/funcionarios")
public class FuncionariosResource {

    @RequestMapping (method = RequestMethod.GET)
    public List<Funcionario> listar(){

        Funcionario funcionarioPadrao1 = new Funcionario(1,"RichTeste", "Gerente", 1000.00, "101010", "");
        Funcionario funcionarioPadrao2 = new Funcionario(2,"SuadTeste", "Gerente", 1000.00, "101010", "");

        List<Funcionario> funcionarioList = new ArrayList<>();
        funcionarioList.add(funcionarioPadrao1);
        funcionarioList.add(funcionarioPadrao2);

        return funcionarioList;
    }
}
