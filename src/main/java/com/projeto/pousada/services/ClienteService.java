package com.projeto.pousada.services;

import com.projeto.pousada.domain.Categoria;
import com.projeto.pousada.domain.Cidade;
import com.projeto.pousada.domain.Cliente;
import com.projeto.pousada.domain.Endereco;
import com.projeto.pousada.domain.enums.TipoCliente;
import com.projeto.pousada.dto.CategoriaDTO;
import com.projeto.pousada.dto.ClienteDTO;
import com.projeto.pousada.dto.ClienteNewDTO;
import com.projeto.pousada.repositories.CategoriaRepository;
import com.projeto.pousada.repositories.ClienteRepository;
import com.projeto.pousada.repositories.EnderecoRepository;
import com.projeto.pousada.services.exceptions.DataIntegratyException;
import com.projeto.pousada.services.exceptions.ObjectNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Cliente find(Integer id) {
        Optional<Cliente> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
    }

    @Transactional
    public Cliente insert(Cliente obj){
        obj.setId(null);
        obj = repository.save(obj);
        enderecoRepository.saveAll(obj.getEnderecos());
        return obj;
    }

    public Cliente update(Cliente obj) {
        Cliente newObj = find(obj.getId());
        updateData(newObj, obj);
        return repository.save(newObj);
    }

    public void delete(Integer id) {
        find(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            log.error(e.getMessage());
            throw new DataIntegratyException("Não é possivel excluir esste item, pois possui outras informações associadas");
        }
    }

    public List<Cliente> findAll() {
        return repository.findAll();
    }

    public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction),
                orderBy);
        return repository.findAll(pageRequest);
    }

    public Cliente fromDTO(ClienteDTO objDTO) {
        return new Cliente(objDTO.getId(), objDTO.getNome(), objDTO.getEmail(), null, null);
    }

    public Cliente fromDTO(ClienteNewDTO objDTO) throws IllegalAccessException {
        Cliente cli = new Cliente(null, objDTO.getNome(), objDTO.getEmail(), objDTO.getCpfCnpj(), TipoCliente.toEnum(objDTO.getTipo()));
        Cidade cid = new Cidade(objDTO.getCidade(), null, null);
        Endereco end = new Endereco(null, objDTO.getLogradouro(), objDTO.getNumero(), objDTO.getComplemento(), objDTO.getBairro(),
                objDTO.getCep(), cli, cid);
        cli.getEnderecos().add(end);
        cli.getTelefones().add(objDTO.getTelefone1());
        if (objDTO.getTelefone2()!=null) {
            cli.getTelefones().add(objDTO.getTelefone2());
        }
        if (objDTO.getTelefone3()!=null) {
            cli.getTelefones().add(objDTO.getTelefone3());
        }
        return cli;
    }

    private void updateData(Cliente newObj, Cliente obj) {
        newObj.setNome(obj.getNome());
        newObj.setEmail(obj.getEmail());
    }

}
