package app.service;

import app.repository.AutorRepository;
import app.model.Autor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public List<Autor> findAll() {
        return autorRepository.findAll();
    }

    public String save(Autor autor) {
        autorRepository.save(autor);
        return "Autor salvo!";
    }

    public Autor findById(Integer id) {
        Autor autor = autorRepository.findById(id);
        if (autor == null) {
            throw new IllegalArgumentException("Autor não encontrado com o ID: " + id);
        }
        return autor;
    }

    public Autor update(Integer id, Autor autor) {
        Autor update = findById(id);

        if (autor.getNome() != null) {
            update.setNome(autor.getNome());
        }

        if (autor.getCpf() != null) {
            update.setCpf(autor.getCpf());
        }

        if (autor.getIdade() != null) {
            update.setIdade(autor.getIdade());
        }

        autorRepository.save(update);
        return update;
    }

    public void delete(Integer id) {
        Autor delete = findById(id);
        autorRepository.delete(delete);
    }
}
