package com.aula.Livraria.repository;

import com.aula.Livraria.models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {

    public List<Livro> findByQtdDisponivel(int qtdDisponivel);

    public List<Livro> findByAutor(String autor);

    public List<Livro> findByNome(String titulo);

}
