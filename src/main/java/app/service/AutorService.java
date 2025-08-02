package app.service;

import app.repository.AutorRepository;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;
import app.model.Autor;
import java.util.List;

@Service
public class AutorService {

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    private final AutorRepository autorRepository;

    public List<Autor> findAll() {
        return autorRepository.findAll();
    }

    public String save(Autor autor) {
        this.autorRepository.save(autor);
        return "Autor salvo!";
    }

    public Autor findById(Integer id) {
        return autorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());
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

        return autorRepository.save(update);
    }

    public void delete(Integer id) {
        Autor delete = findById(id);
        autorRepository.delete(delete);
    }

}
