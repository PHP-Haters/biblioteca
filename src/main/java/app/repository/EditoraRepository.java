package app.repository;


import app.model.Editora;
import app.model.Editora;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EditoraRepository {
    private List<Editora> pseudoEditorasTable = new ArrayList<>();

    public EditoraRepository() {
        popularEditoras();
    }

    private void popularEditoras() {
        Editora b1 = new Editora();
        b1.setId(1);
        b1.setNome("Editora Central");
        b1.setTelefone("(11) 1111-1111");

        Editora b2 = new Editora();
        b2.setId(2);
        b2.setNome("Editora do Bairro");
        b2.setTelefone("(11) 2222-2222");

        Editora b3 = new Editora();
        b3.setId(3);
        b3.setNome("Editora Infantil");
        b3.setTelefone("(11) 3333-3333");

        Editora b4 = new Editora();
        b4.setId(4);
        b4.setNome("Editora Universitária");
        b4.setTelefone("(11) 4444-4444");

        Editora b5 = new Editora();
        b5.setId(5);
        b5.setNome("Editora Comunitária");
        b5.setTelefone("(11) 5555-5555");

        pseudoEditorasTable.add(b1);
        pseudoEditorasTable.add(b2);
        pseudoEditorasTable.add(b3);
        pseudoEditorasTable.add(b4);
        pseudoEditorasTable.add(b5);
    }

    // Retorna todas as editoras
    public List<Editora> listAll() {
        return pseudoEditorasTable;
    }

    public Editora findById(int id) {
        for (Editora editora : pseudoEditorasTable) {
            if (editora.getId() == id) {
                return editora;
            }
        }
        return null;
    }

    public void save(Editora editora) {
        pseudoEditorasTable.add(editora);
    }

    public void deleteById(int id) {
        for (int i = 0; i < pseudoEditorasTable.size(); i++) {
            if (pseudoEditorasTable.get(i).getId() == id) {
                pseudoEditorasTable.remove(i);
                return;
            }
        }
    }

    public void update(int id, Editora novaEditora) {
        for (int i = 0; i < pseudoEditorasTable.size(); i++) {
            Editora editoraAtual = pseudoEditorasTable.get(i);
            if (editoraAtual.getId() == id) {
                novaEditora.setId(id);
                pseudoEditorasTable.set(i, novaEditora);
                return;
            }
        }
    }
}
