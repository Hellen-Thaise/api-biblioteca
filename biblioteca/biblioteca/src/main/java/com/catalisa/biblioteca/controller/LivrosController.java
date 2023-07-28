package com.catalisa.biblioteca.controller;

import com.catalisa.biblioteca.model.LivrosModel;
import com.catalisa.biblioteca.service.LivrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LivrosController {

    @Autowired
    LivrosService livrosService;

    // ENDPOINTS

    // REQUISIÇÕES GET
    // método para mostrar todos os livros
    @GetMapping(path = "/livros")
    public List<LivrosModel> exibirTodosOsLivros(){
        return livrosService.exibirTodos();
    }

    // método para buscar um livro pela sua id
    @GetMapping(path = "/livros/{id}")
    public Optional<LivrosModel> buscarLivroPorId(@PathVariable Long id){
        return livrosService.buscarPorId(id);
    }

    //REQUISIÇÃO POST - insere um novo livro no banco de dados
    @PostMapping(path = "/livros")
    @ResponseStatus(HttpStatus.CREATED)
    public LivrosModel inserirNovoLivro(@RequestBody LivrosModel livrosModel){
        return livrosService.inserir(livrosModel);
    }

    //REQUISIÇÃO PUT - altera um livro já cadastrado no banco de dados
    @PutMapping(path = "/livros/{id}")
    public LivrosModel alterarLivro(@PathVariable Long id, @RequestBody LivrosModel livrosModel){
        return livrosService.alterar(id,livrosModel);
    }

    // REQUISIÇÃO DELETE - deleta um livro do banco de dados
    @DeleteMapping(path = "/livros/{id}")
    public void deletarLivro(@PathVariable Long id){
        livrosService.deletar(id);
    }

}
