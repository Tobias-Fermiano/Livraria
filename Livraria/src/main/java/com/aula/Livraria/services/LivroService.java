package com.aula.Livraria.services;

import com.aula.Livraria.models.Livro;
import com.aula.Livraria.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public Livro create(Livro livro){
        return livroRepository.save(livro);
    }

    public List<Livro> getAll(){
        return livroRepository.findAll();
    }

    public Optional<Livro> getById(Integer id){
        return this.livroRepository.findById(id);
    }

    public Optional<Livro> updateById(Integer idLivro, Integer qtdDisponivel, String titulo, String autor, String editora, Date dataPublicacao, String categoria) throws Exception {
        if(this.getById(idLivro).isPresent()){
            Livro livro = this.getById(idLivro).get();

            if(qtdDisponivel != null && qtdDisponivel >= 0){
                livro.setQtdDisponivel(qtdDisponivel);
            }
            if(titulo != null && !titulo.isBlank()){
                livro.setTitulo(titulo);
            }
            if(autor != null && !autor.isBlank()){
                livro.setAutor(autor);
            }
            if(editora != null && !editora.isBlank()){
                livro.setEditora(editora);
            }
            if(!dataPublicacao.equals("")){
                livro.setDataPublicacao(dataPublicacao);
            }
            if(categoria != null && !categoria.isBlank()){
                livro.setCategoria(categoria);
            }
            return Optional.of(this.livroRepository.save(livro));
        }else {
            throw new Exception("Não encontrado registro!");
        }
    }

    public Optional<Livro> deleteById(Integer idLivro) throws Exception {

        try {
            if(this.getById(idLivro).isPresent()){
                this.livroRepository.delete(this.getById(idLivro).get());
            }
        }catch (Exception e) {
            throw new Exception("Não encontrado registro! Id: " + idLivro);
        }
        return Optional.empty();
    }

}

