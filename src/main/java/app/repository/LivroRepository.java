package app.repository;

import app.model.Livro;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LivroRepository {
    private List<Livro> pseudoLivroTable = new ArrayList<>();

    public LivroRepository() {
        // Ao instanciar um objeto da classe LivroRepository
        // A pseudo tabela é populada
        popularLivros();
    }

    private void popularLivros() {
        Livro liv1 = new Livro();
        liv1.setId(1);
        liv1.setPaginas(544);
        liv1.setSinopse("A vida do jovem Paul Atreides está prestes a mudar radicalmente. Após a visita de uma mulher misteriosa, ele é obrigado a deixar seu planeta natal para sobreviver ao ambiente árido e severo de Arrakis, o Planeta Deserto.");
        liv1.setTitulo("Duna");

        Livro liv2 = new Livro();
        liv2.setId(2);
        liv2.setPaginas(320);
        liv2.setSinopse("Há doze mil anos, o Império Galáctico reina, absoluto, sobre todos os mundos habitados. Mas esse reinado ignora um futuro terrível: uma crise levará a humanidade a uma era sombria de ignorância e barbárie que se estenderá por milênios. O único homem a prever a tragédia é Hari Seldon.");
        liv2.setTitulo("Fundação");

        Livro liv3 = new Livro();
        liv3.setId(3);
        liv3.setPaginas(656);
        liv3.setSinopse("Ninguém sabe ao certo quem é o herói ou o vilão desse fascinante universo criado por Patrick Rothfuss. Na realidade, essas duas figuras se concentram em Kote, um homem enigmático que se esconde sob a identidade de proprietário da hospedaria Marco do Percurso.");
        liv3.setTitulo("O Nome do Vento");

        Livro liv4 = new Livro();
        liv4.setId(4);
        liv4.setPaginas(356);
        liv4.setSinopse("Em um futuro próximo, um único soberano governa o estado totalitário da Oceania: o Grande Irmão. Embora nunca tenha sido visto, ninguém escapa à vigilância asfixiante do olho que tudo vê, ao poder da Polícia do Pensamento ou às imposições do Ministério da Verdade. Nada, entretanto, é aparentemente proibido, pois vigora uma única regra: rejeitar as provas materiais que seus olhos e ouvidos oferecem.");
        liv4.setTitulo("1984");

        Livro liv5 = new Livro();
        liv5.setId(5);
        liv5.setPaginas(480);
        liv5.setSinopse("Isabella Swan chega à nublada e chuvosa cidadezinha de Forks - último lugar onde gostaria de viver. Tenta se adaptar à vida provinciana na qual aparentemente todos se conhecem, lidar com sua constrangedora falta de coordenação motora e se habituar a morar com um pai com quem nunca conviveu. Em seu destino está Edward Cullen.");
        liv5.setTitulo("Crepúsculo");

        pseudoLivroTable.add(liv1);
        pseudoLivroTable.add(liv2);
        pseudoLivroTable.add(liv3);
        pseudoLivroTable.add(liv4);
        pseudoLivroTable.add(liv5);
    }

    // Retorna todos os livros
    public List<Livro> listAll() {
        return pseudoLivroTable;
    }

    // Retorna o livro com base no ID
    public Livro findById(int id) {
        for (Livro livro : pseudoLivroTable) {
            if (livro.getId() == id) {
                return livro;
            }
        }
        return null;
    }

    // Salva um novo livro na lista
    public void save(Livro livro) {
        pseudoLivroTable.add(livro);
    }

    public void update(int id, Livro novoLivro) {
        for (int i = 0; i < pseudoLivroTable.size(); i++) {
            Livro livroAtual = pseudoLivroTable.get(i);
            if (livroAtual.getId() == id) {
                // Garante que o ID permanece o mesmo
                novoLivro.setId(id);
                pseudoLivroTable.set(i, novoLivro);
                return;
            }
        }
    }

    // Deleta o livro encontrado com o id correspondente
    public void deleteById(int id) {
        for (int i = 0; i < pseudoLivroTable.size(); i++) {
            if (pseudoLivroTable.get(i).getId() == id) {
                pseudoLivroTable.remove(i);
                return;
            }
        }
    }
}
