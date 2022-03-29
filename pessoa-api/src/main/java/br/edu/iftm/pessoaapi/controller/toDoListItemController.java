package br.edu.iftm.pessoaapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.edu.iftm.pessoaapi.domain.todoListItem;
import br.edu.iftm.pessoaapi.service.toDoListItemService;

@RestController
@RequestMapping("/todolist/{idList}/todolistitem")
class TodoListItemController {

    @Autowired
    toDoListItemService service;

    @GetMapping
    public ResponseEntity<List<todoListItem>> getAll(@PathVariable("idList") Integer id) {
        List<todoListItem> items = service.GetAll(id);
        if (items.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        return ResponseEntity.status(HttpStatus.OK).body(items);
    }

    @GetMapping("{id}")
    public ResponseEntity<todoListItem> getById(@PathVariable("id") Integer id) {
        Optional<todoListItem> existingItemOptional = service.GetById(id);

        if (existingItemOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(existingItemOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<todoListItem> create(@RequestBody todoListItem todoListItem, 
                @PathVariable("idList") Integer id) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(todoListItem, id));
    }

    @PutMapping("{id}")
    public ResponseEntity<todoListItem> update(@PathVariable("id") Integer id,
            @RequestBody todoListItem item, @PathVariable("idList") Integer idList) {
                todoListItem todoListItem = service.update(item, id, idList);
        if (todoListItem != null) {
            return ResponseEntity.status(HttpStatus.OK).body(todoListItem);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Integer id) {
        try {
            service.delete(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception exc) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Recurso mão encontrado", exc);
        }
    }
}
