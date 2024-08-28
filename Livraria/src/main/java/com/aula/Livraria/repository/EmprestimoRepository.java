package com.aula.Livraria.repository;

import com.aula.Livraria.models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository<Livro, Integer> {
}
