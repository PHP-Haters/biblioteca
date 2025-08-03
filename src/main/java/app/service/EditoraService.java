package app.service;

import app.model.Editora;
import app.model.Editora;
import app.repository.EditoraRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditoraService {

    private final EditoraRepository repository;

    public EditoraService(EditoraRepository repository) {
        this.repository = repository;
    }

    public List<Editora> listAll() {
        List<Editora> lista = repository.listAll();
        if (lista.isEmpty()) {
            throw new IllegalArgumentException("Nenhuma editora cadastrada.");
        }
        return lista;
    }

    public Editora findById(int id) {
        Editora editora = repository.findById(id);
        if (editora == null) {
            throw new IllegalArgumentException("Editora com ID " + id + " não encontrada.");
        }
        return editora;
    }

    public String save(Editora editora) {
        if (editora.getId() == null || editora.getNome() == null || editora.getTelefone() == null) {
            throw new IllegalArgumentException("Envie id, nome e telefone para a editora.");
        }

        if (repository.findById(editora.getId()) != null) {
            throw new IllegalArgumentException("Já há uma editora cadastrada com esse id.");
        }

        repository.save(editora);
        return "Sucesso ao salvar editora.";
    }

    public String deleteById(int id){
        // Checa se a editora realmente existe
        Editora editora = repository.findById(id);
        if (editora == null) {
            throw new IllegalArgumentException("Editora com ID " + id + " não encontrada.");
        }

        repository.deleteById(id);
        return "Sucesso ao deletar editora.";
    }

    public String update(int id, Editora editora) {
        // Checa se todos os campos da editora foram preenchidos
        if (editora.getNome() == null || editora.getTelefone() == null) {
            throw new IllegalArgumentException("Envie um novo nome e telefone para a editora.");
        }

        // Checa se a editora existe
        if (repository.findById(id) == null) {
            throw new IllegalArgumentException("Não há nenhuma editora com o id especificado.");
        }

        repository.update(id, editora);
        return "Sucesso ao editar editora.";
    }
}
