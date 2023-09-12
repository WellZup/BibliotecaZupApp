package com.catalisa.Exercicio.controller;

import com.catalisa.Exercicio.model.LivrosModel;
import com.catalisa.Exercicio.service.LivrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/livros/") //path
public class LivrosController {

    @Autowired
    LivrosService livrosService;

    //Requisicao get
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping
    public List<LivrosModel> buscaTodosLivros() {
        return livrosService.buscarTodos();
    }

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping(path = "{id}")
    public Optional<LivrosModel> buscarLivrosPorId(@PathVariable Long id) {
        return livrosService.buscarPorId(id);
    }

    //Requisição Post
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LivrosModel cadastrarNovoLivro(@RequestBody LivrosModel livrosModel) {
        return livrosService.cadastrar(livrosModel);
    }

    //Requisição Put
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping(path = "{id}")
    public LivrosModel alteraLivro(@PathVariable Long id, @RequestBody LivrosModel livrosModel) {
        return livrosService.alterar(id, livrosModel);
    }

    //Requisição DELETE
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(path = "{id}")
    public void deletaLivro(@PathVariable Long id) {
        livrosService.deletar(id);
    }
}
