package com.catalisa.biblioteca.service;

import com.catalisa.biblioteca.model.LivrosModel;
import com.catalisa.biblioteca.repository.LivrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivrosService {

    @Autowired
    LivrosRepository livrosRepository;

    // MÉTODOS

    // método para exibir todos os livros cadastrados no banco de dados
    public List<LivrosModel> exibirTodos(){
        return livrosRepository.findAll();
    }

    // método para buscar livro por id
    public Optional<LivrosModel> buscarPorId(Long id){
        return livrosRepository.findById(id);
    }

    // método para inserir um novo livro no banco de dados
    public LivrosModel inserir(LivrosModel livrosModel){
        return livrosRepository.save(livrosModel);
    }

    // método para alterar o cadastro de um livro
    public LivrosModel alterar(Long id, LivrosModel livrosModel){
        LivrosModel livro = buscarPorId(id).get();

        if(livrosModel.getTitulo() != null){
            livro.setTitulo(livrosModel.getTitulo());
        }
        if(livrosModel.getAutor() != null){
            livro.setAutor(livrosModel.getAutor());
        }
        if(livrosModel.getAnoLancamento() != null) {
            livro.setAnoLancamento(livrosModel.getAnoLancamento());
        }
        if(livrosModel.getIsbn() != null){
            livro.setIsbn(livrosModel.getIsbn());
        }
        return livrosRepository.save(livro);

    }

    // método para deletar um livro do banco de dados
    public void deletar (Long id){
        livrosRepository.deleteById(id);
    }

}
