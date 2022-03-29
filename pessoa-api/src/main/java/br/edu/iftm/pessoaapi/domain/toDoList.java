package br.edu.iftm.pessoaapi.domain;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.edu.iftm.pessoaapi.model.toDoListItem;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity

public class toDoList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String nome;
    private Integer id;

    @OneToMany(mappedBy = "toDoList")
    private ArrayList<toDoListItem> toDoListItems = new ArrayList<toDoListItem>();

    public toDoList(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
