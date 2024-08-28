package com.aula.Livraria.repository;

import com.aula.Livraria.models.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Emprestimo, Integer> {
}
