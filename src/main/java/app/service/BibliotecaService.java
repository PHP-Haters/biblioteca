package app.service;

import app.model.Biblioteca;
import app.repository.BibliotecaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BibliotecaService {

    private final BibliotecaRepository repository;

    public BibliotecaService(BibliotecaRepository repository) {
        this.repository = repository;
    }

    public List<Biblioteca> listAll() {
        List<Biblioteca> lista = repository.listAll();
        if (lista.isEmpty()) {
            throw new IllegalArgumentException("Nenhuma biblioteca cadastrada.");
        }
        return lista;
    }

    public Biblioteca findById(int id) {
        Biblioteca biblioteca = repository.findById(id);
        if (biblioteca == null) {
            throw new IllegalArgumentException("Biblioteca com ID " + id + " não encontrada.");
        }
        return biblioteca;
    }

    public String save(Biblioteca biblioteca) {
        if (biblioteca.getId() == null || biblioteca.getNome() == null || biblioteca.getTelefone() == null) {
            throw new IllegalArgumentException("Envie id, nome e telefone para a biblioteca.");
        }

        if (repository.findById(biblioteca.getId()) != null) {
            throw new IllegalArgumentException("Já há uma biblioteca cadastrada com esse id.");
        }

        repository.save(biblioteca);
        return "Sucesso ao salvar biblioteca.";
    }

    public String deleteById(int id){
        // Checa se a biblioteca realmente existe
        Biblioteca biblioteca = repository.findById(id);
        if (biblioteca == null) {
            throw new IllegalArgumentException("Biblioteca com ID " + id + " não encontrada.");
        }

        repository.deleteById(id);
        return "Sucesso ao deletar biblioteca.";
    }
}
