package com.aula.Livraria.models;


import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "tb_usuario")
public class Usuario {

    @Id @GeneratedValue(strategy = GenerationType.AUTO.SEQUENCE)
    private Integer id;

    private String nome;
    private String matricula;
    private String senha;
}
