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
        return livrosRepository.save(livrosModel);
    }

    public LivrosModel alterar(Long id, LivrosModel livrosModel) {
        LivrosModel livroExistente = buscarPorId(id).orElse(null);

        if (livroExistente != null) {
            if (livrosModel.getAutor() != null) {
                livroExistente.setAutor(livrosModel.getAutor());
            }

            if (livrosModel.getNome() != null) {
                livroExistente.setNome(livrosModel.getNome());
            }

            if (livrosModel.getLancamento() != null) {
                livroExistente.setLancamento(livrosModel.getLancamento());
            }

            if (livrosModel.getCodlivro() != null) {
                livroExistente.setCodlivro(livrosModel.getCodlivro());
            }

            return livrosRepository.save(livroExistente);
        }

        return null; // Retorna null se o livro não for encontrado
    }

    public void deletar(Long id) {
        livrosRepository.deleteById(id);
    }
}