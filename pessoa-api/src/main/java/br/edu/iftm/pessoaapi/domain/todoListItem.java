package br.edu.iftm.pessoaapi.domain;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity

public class todoListItem {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    private Integer idItem;
    private String nomeDoItem;

    @ManyToOne

    @JsonBackReference

    private toDoList todoList;

    public Integer getidItem() {
        return this.idItem;
    }

    public void setidItem(Integer idItem) {
        this.idItem = idItem;
    }

    public String getnomeDoItem() {
        return this.nomeDoItem;
    }

    public void setnomeDoItem(String nomeDoItem) {
        this.nomeDoItem = nomeDoItem;
    }
}
