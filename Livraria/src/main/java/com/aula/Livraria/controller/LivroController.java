package com.aula.Livraria.controller;

import com.aula.Livraria.models.Livro;
import com.aula.Livraria.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping("/all")
    public ResponseEntity<List<Livro>> getAll() {
        try {
            List<Livro> livros = livroService.getAll();
            return new ResponseEntity<>(livros, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Livro> create(@RequestBody Livro livro) throws Exception {
        try {
            Livro livroSalvo = livroService.create(livro);
            return new ResponseEntity<>(livroSalvo, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    //get por id
    @GetMapping("/idLivro")
    public ResponseEntity<Livro> getLivro(@RequestParam("id") Integer id) {
        Livro livro = null;
        try {
            if (this.livroService.getById(id).isPresent()) {
                livro = livroService.getById(id).get();
                return new ResponseEntity<>(livro, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity updateLivro(@PathVariable Integer id, @RequestBody Map object){

        Integer qtdDisponivel = null;
        String titulo = null;
        String autor = null;
        String editora = null;
        Date dataPublicacao = null;
        String categoria = null;

        if(object.get("qtdDisponivel") != null){
            qtdDisponivel = (Integer) object.get("qtdDisponivel");
        }

        if(object.get("titulo") != null){
            titulo = object.get("titulo").toString();
        }

        if(object.get("autor") != null){
            autor = object.get("autor").toString();
        }

        if(object.get("editora") != null){
            editora = object.get("editora").toString();
        }

        if(object.get("dataPublicacao") != null){
            dataPublicacao = (Date) object.get("dataPublicacao");
        }

        if(object.get("categoria") != null){
            categoria = object.get("categoria").toString();
        }

        try {
            Optional<Livro> livroAtualizado = livroService.updateById(id, qtdDisponivel, titulo, autor, editora, dataPublicacao, categoria);
            return new ResponseEntity<>(livroAtualizado, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Livro> deleteLivro(@PathVariable Integer id) {
        try {
            Optional<Livro> livroAtualizado = livroService.getById(id);
            if (livroAtualizado.isPresent()) {
                livroService.deleteById(id);
            }
            return new ResponseEntity<>(livroAtualizado.get(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

