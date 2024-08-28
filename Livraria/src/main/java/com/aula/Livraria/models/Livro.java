package com.aula.Livraria.models;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@AllArgsConstructor @NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "tb_livro")
public class Livro {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer qtdDisponivel;
    private String titulo;
    private String autor;
    private String editora;
    private Date dataPublicacao;
    private String categoria;
}
