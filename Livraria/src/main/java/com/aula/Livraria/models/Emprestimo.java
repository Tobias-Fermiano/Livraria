package com.aula.Livraria.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@AllArgsConstructor @NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "tb_emprestimo")
public class Emprestimo {

    @Id @GeneratedValue(strategy = GenerationType.AUTO.SEQUENCE)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_livro", foreignKey = @ForeignKey(name = "emprestimo_livro"), nullable = false)
    private Livro livro;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario", foreignKey = @ForeignKey(name = "emprestimo_usuario"), nullable = false)
    Usuario user = new Usuario();

    private Date data_emprestimo;
    private Date data_devolucao;
    private Date data_devolvido;
}
