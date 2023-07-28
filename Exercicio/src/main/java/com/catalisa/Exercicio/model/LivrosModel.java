package com.catalisa.Exercicio.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
public class LivrosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, nullable = false)
    private String nome;
    @Column(length = 50, nullable = false)
    private String autor;
    @Column(length = 25, nullable = false)
    private String lancamento;
    @Column(length = 15, nullable = false)
    private Long codlivro;
}
