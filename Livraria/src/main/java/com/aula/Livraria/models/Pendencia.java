package com.aula.Livraria.models;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "tb_pendencia")
public class Pendencia {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Double valor_pendencia;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_pendencia", foreignKey = @ForeignKey(name = "pendencia_emprestimo"), nullable = false)
    private Emprestimo emprestimo;
}
