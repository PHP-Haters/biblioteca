package app.repository;

import app.model.Biblioteca;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BibliotecaRepository {
    private List<Biblioteca> pseudoBibliotecasTable = new ArrayList<>();

    public BibliotecaRepository() {
        // Ao instanciar um objeto da classe BibliotecaRepository
        // A pseudo tabela é populada
        popularBibliotecas();
    }

    private void popularBibliotecas() {
        Biblioteca b1 = new Biblioteca();
        b1.setId(1);
        b1.setNome("Biblioteca Central");
        b1.setTelefone("(11) 1111-1111");

        Biblioteca b2 = new Biblioteca();
        b2.setId(2);
        b2.setNome("Biblioteca do Bairro");
        b2.setTelefone("(11) 2222-2222");

        Biblioteca b3 = new Biblioteca();
        b3.setId(3);
        b3.setNome("Biblioteca Infantil");
        b3.setTelefone("(11) 3333-3333");

        Biblioteca b4 = new Biblioteca();
        b4.setId(4);
        b4.setNome("Biblioteca Universitária");
        b4.setTelefone("(11) 4444-4444");

        Biblioteca b5 = new Biblioteca();
        b5.setId(5);
        b5.setNome("Biblioteca Comunitária");
        b5.setTelefone("(11) 5555-5555");

        pseudoBibliotecasTable.add(b1);
        pseudoBibliotecasTable.add(b2);
        pseudoBibliotecasTable.add(b3);
        pseudoBibliotecasTable.add(b4);
        pseudoBibliotecasTable.add(b5);
    }

    // Retorna todas as bibliotecas
    public List<Biblioteca> listAll() {
        return pseudoBibliotecasTable;
    }

    // Retorna a biblioteca com base no ID
    public Biblioteca findById(int id) {
        for (Biblioteca biblioteca : pseudoBibliotecasTable) {
            if (biblioteca.getId() == id) {
                return biblioteca;
            }
        }
        return null;
    }

    // Salva uma nova biblioteca na lista
    public void save(Biblioteca biblioteca) {
        pseudoBibliotecasTable.add(biblioteca);
    }
}
