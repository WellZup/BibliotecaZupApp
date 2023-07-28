package com.catalisa.Exercicio.service;

import com.catalisa.Exercicio.model.LivrosModel;
import com.catalisa.Exercicio.repository.LivrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivrosService {


    @Autowired
    LivrosRepository livrosRepository;

    public List<LivrosModel> buscarTodos() {
        return livrosRepository.findAll();
    }

    public Optional<LivrosModel> buscarPorId(Long id) {
        return livrosRepository.findById(id);
    }

    public LivrosModel cadastrar(LivrosModel livrosModel) {
//        livrosModel.getId();
//        livrosModel.getNome();
//        livrosModel.getAutor();
//        livrosModel.getLancamento();
//        livrosModel.getCodlivro();

        return livrosRepository.save(livrosModel);
    }

    public LivrosModel alterar(Long id, LivrosModel livrosModel) {

          LivrosModel livros = buscarPorId(id).get();
//        livrosModel.getId();
//        livrosModel.getNome();
//        livrosModel.getAutor();
//        livrosModel.getLancamento();
//        livrosModel.getCodlivro();

        if (livrosModel.getAutor() != null) {
            livrosModel.setAutor(livrosModel.getAutor());
        }

        if (livrosModel.getNome() != null) {
            livrosModel.setNome(livrosModel.getNome());
        }

        if (livrosModel.getLancamento() != null ) {
            livrosModel.setLancamento(livrosModel.getLancamento());
        }

        if (livrosModel.getCodlivro() !=null) {
            livrosModel.setCodlivro(livrosModel.getCodlivro());
        }

        return livrosRepository.save(livros);
    }

    public void deletar(Long id) {
        livrosRepository.deleteById(id);
    }
}
