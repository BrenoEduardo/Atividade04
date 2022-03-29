package br.edu.iftm.pessoaapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import antlr.collections.List;
import br.edu.iftm.pessoaapi.repository.TodoListItemRepository;

@Service
public class toDoListItemService {
    @Autowired
    private TodoListItemRepository repository;
    @Autowired
    private TodoListItemRepository listRepository;

    public List<todoListItem> GetAll(Integer iDList) {
        toDoList todoList = listRepository.findById(iDList).get();
        return repository.findByTodoList(todoList);
    }

    public Optional<todoListItem> GetById(Integer id) {
        return repository.findById(id);
    }

    public todoListItem create(todoListItem todoListItem, Integer iDList) {
        todoList todoList = listRepository.findById(iDList).get();
        todoListItem.setTodoList(todoList);
        return repository.save(todoListItem);
    }

    public todoListItem update(todoListItem todoListItem, Integer id, Integer idList) {
        if (repository.existsById(id)) {
            todoListItem.setId(id);
            todoListItem.setTodoList(listRepository.findById(idList).get());
            return repository.save(todoListItem);
        }
        return null;
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
