package com.projeto.pousada.services;

import com.projeto.pousada.domain.Categoria;
import com.projeto.pousada.repositories.CategoriaRepository;
import com.projeto.pousada.services.exceptions.DataIntegratyException;
import com.projeto.pousada.services.exceptions.ObjectNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
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

        public Categoria update(Categoria obj){
            find(obj.getId());
            return  repository.save(obj);
        }

    public void delete(Integer id){
        find(id);
        try{
            repository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            log.error(e.getMessage());
            throw new DataIntegratyException("Não é possivel excluir esste item, pois possui outras informações associadas");
        }
    }

    public List<Categoria> findAll() {
           return repository.findAll();
    }

}
