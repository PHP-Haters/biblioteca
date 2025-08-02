package app.service;

import app.model.Livro;
import app.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    private final LivroRepository repository;

    public LivroService(LivroRepository repository) {
        this.repository = repository;
    }

    public List<Livro> listAll() {
        List<Livro> lista = repository.listAll();
        if (lista.isEmpty()) {
            throw new IllegalArgumentException("Nenhum livro cadastrado.");
        }
        return lista;
    }

    public Livro findById(int id) {
        Livro livro = repository.findById(id);
        if (livro == null) {
            throw new IllegalArgumentException("Livro com ID " + id + " não encontrado.");
        }
        return livro;
    }

    public String save(Livro livro) {
        if (livro.getId() == null || livro.getPaginas() == null || livro.getSinopse() == null || livro.getTitulo() == null) {
            throw new IllegalArgumentException("Envie id, quantidade de páginas, sinopse do livro e seu título para adicionar o livro.");
        }

        if (repository.findById(livro.getId()) != null) {
            throw new IllegalArgumentException("Já há um livro cadastrado com esse id.");
        }

        repository.save(livro);
        return "Sucesso ao salvar o livro.";
    }

    public String deleteById(int id){
        // Checa se o livro  realmente existe
        Livro livro = repository.findById(id);
        if (livro == null) {
            throw new IllegalArgumentException("Livro com ID " + id + " não encontrada.");
        }

        repository.deleteById(id);
        return "Sucesso ao deletar o livro.";
    }

    public String update(int id, Livro livro) {
        // Checa se todos os campos do livro foram preenchidos
        if (livro.getPaginas() == null || livro.getSinopse() == null || livro.getTitulo() == null) {
            throw new IllegalArgumentException("Envie as novas caracteristicas do livro.");
        }

        // Checa se o livro existe
        if (repository.findById(id) == null) {
            throw new IllegalArgumentException("Não há nenhum livro com o id especificado.");
        }

        repository.update(id, livro);
        return "Sucesso ao editar o livro.";
    }
}
