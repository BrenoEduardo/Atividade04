package br.edu.iftm.pessoaapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iftm.pessoaapi.domain.toDoList;

import br.edu.iftm.pessoaapi.service.toDoListService;

@RestController
@RequestMapping("/todolist")
class toDoListController {

    @Autowired
    toDoListService service;

    @GetMapping
    public ResponseEntity<List<toDoList>> getAll() {
            List<toDoList> items = service.getAll();

            if (items.isEmpty())
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

            return ResponseEntity.status(HttpStatus.OK).body(items);
    }

    @GetMapping("{id}")
    public ResponseEntity<toDoList> getById(@PathVariable("id") Integer id) {
        Optional<toDoList> existingItemOptional = service.getById(id);

        if (existingItemOptional.isPresent()) {
            return ResponseEntity.status( HttpStatus.OK).body(existingItemOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<toDoList> create(@RequestBody toDoList toDoList) {
            return  ResponseEntity.status(HttpStatus.CREATED).body(service.create(toDoList));
    }

    @PutMapping("{id}")
    public ResponseEntity<toDoList> update(@PathVariable("id") Integer id, @RequestBody toDoList toDoList) {
        toDoList todolist = service.update(toDoList, id);
        if (todolist!=null) {
            return ResponseEntity.status(HttpStatus.OK).body(toDoList);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Integer id) {
            service.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
     
}
}