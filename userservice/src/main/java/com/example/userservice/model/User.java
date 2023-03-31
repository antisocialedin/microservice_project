package com.example.userservice.model;


import jakarta.persistence.*;

@Entity //generate entity user
public class User {
    @Id //id bd
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrement id bd
    private Long id;

    @Column(nullable = false) //Column not null
    private String nome;

    @Column(nullable = false) //Column not null
    private String idade;

    @Column(nullable = false) //Column not null
    private String telefone;

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
