package br.edu.iftm.pessoaapi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.iftm.pessoaapi.model.toDoListItem;
import net.bytebuddy.description.ByteCodeElement.Token.TokenList;

@Repository
public interface TodoListItemRepository extends CrudRepository<toDoListItem,Integer> {
   
    List<toDoListItem>List(TokenList todoList);
}