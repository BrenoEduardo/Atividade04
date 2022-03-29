package br.edu.iftm.pessoaapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iftm.pessoaapi.domain.toDoList;
import br.edu.iftm.pessoaapi.repository.toDoListRepository;

@Service
public class toDoListService {
    
    @Autowired
    private toDoListRepository repository;

    public List <toDoList>getAll(){

        return repository.findAll();
    }
    public Optional<toDoList> getById(Integer id){
        return repository.findById(id);
    }
    public toDoList create(toDoList toDoList){
        return repository.save(toDoList);
    }
    public toDoList update(toDoList toDoList, Integer id){
        if(repository.existsById(id)){
            toDoList.setId(id);
            return repository.save(toDoList);
        }
        return null;
    }
    public void delete(Integer id){
        repository.deleteById(id);
    
    }
}
