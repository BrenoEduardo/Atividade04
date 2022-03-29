package br.edu.iftm.pessoaapi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.iftm.pessoaapi.domain.toDoList;

@Repository
public interface toDoListRepository extends CrudRepository<toDoList,Integer>{

    @Override
    public List<toDoList> findAll();
    
}
