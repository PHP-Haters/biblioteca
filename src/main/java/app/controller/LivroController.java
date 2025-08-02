package app.controller;

import app.model.Livro;
import app.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroController {
    @Autowired
    private LivroService livroService;

    // Post no endpoint "/livro"
    @PostMapping
    public ResponseEntity<String> save(@RequestBody Livro livro) {
        try {
            String response = this.livroService.save(livro);

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro interno ao salvar o livro!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // GetLivroById no endpoint "/livro/{id}"
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        try {
            Livro livroEncontrado = this.livroService.findById(id);

            return new ResponseEntity<>(livroEncontrado, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro interno ao buscar o livro!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping({"", "/"})
    public ResponseEntity<?> listAll(){
        try {
            List<Livro> todosLivros = this.livroService.listAll();

            return new ResponseEntity<>(todosLivros, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro interno ao buscar os livros.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id){
        try {
            String resposta = this.livroService.deleteById(id);

            return new ResponseEntity<String>(resposta, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<String>("Erro interno ao deletar o livro.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody Livro livro){
        try {
            String response = this.livroService.update(id, livro);

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro interno ao editar o livro!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
