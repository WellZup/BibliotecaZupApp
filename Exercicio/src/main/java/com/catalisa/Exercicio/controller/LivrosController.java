package com.catalisa.Exercicio.controller;

import com.catalisa.Exercicio.model.LivrosModel;
import com.catalisa.Exercicio.service.LivrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LivrosController {

    @Autowired
    LivrosService livrosService;
    //Endpoints

    //Requisicção Get
    @GetMapping(path = "/livros")
    public List<LivrosModel> buscaTodosLivros() {
        return livrosService.buscarTodos();
    }

    @GetMapping(path = "/livros/{id}")
    public Optional<LivrosModel> buscarLivrosPorId(@PathVariable Long id) {
        return livrosService.buscarPorId(id);
    }

    //Requisição Post

    @PostMapping(path = "/livros")
    @ResponseStatus(HttpStatus.CREATED)
    public LivrosModel cadastrarNovoLivro(@RequestBody LivrosModel livrosModel) {
        return null;
    }

    //Requisição Put
    @PutMapping(path = "/livros/{id}")
    public LivrosModel alteraLivro(@PathVariable Long id,
                                   @RequestBody LivrosModel livrosModel) {

        return livrosService.alterar(id, livrosModel);

    }

    //Requisição DELETE

    @DeleteMapping(path = "/livros/{id}")
    public void deletaLivro(@PathVariable Long id) {
        livrosService.deletar(id);
    }

}
