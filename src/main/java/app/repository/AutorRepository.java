package app.repository;

import app.model.Autor;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class AutorRepository {

    private final Map<Integer, Autor> autores = new HashMap<>();
    private int proximoId = 1; // ID incremental

    public List<Autor> findAll() {
        return new ArrayList<>(autores.values());
    }

    public Autor findById(Integer id) {
        return autores.get(id);
    }

    public void save(Autor autor) {
        if (autor.getId() == null) {
            autor.setId(proximoId++);
        }
        autores.put(autor.getId(), autor);
    }

    public void delete(Autor autor) {
        autores.remove(autor.getId());
    }
}
