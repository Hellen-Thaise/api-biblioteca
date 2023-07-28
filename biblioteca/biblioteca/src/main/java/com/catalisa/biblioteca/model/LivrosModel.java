package com.catalisa.biblioteca.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

// indicando que a classe é uma entidade do banco de dados e uma tabela
@Entity
@Table(name = "TB_LIVROS")

//criando getters, setters e constructors
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LivrosModel {

    // criando a chave primária
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // criando coluna de titulo
    @Column(length = 300, nullable = false)
    private String titulo;

    // criando coluna de autor
    @Column(length = 200, nullable = false)
    private String autor;

    // criando coluna de ano de lançamento
    @Column(length = 4, nullable = false)
    private String anoLancamento;

    // criando coluna de código ISBN
    @Column(length = 13, nullable = false)
    private String isbn;

}
