package com.catalisa.Exercicio.model;


import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
@Entity
@Table (name = "TB_LIVROS") //criaçao de tabela
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
