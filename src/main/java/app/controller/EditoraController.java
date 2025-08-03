package app.controller;


import app.model.Editora;
import app.service.EditoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/editora")
public class EditoraController {
    @Autowired
    private EditoraService editoraService;

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Editora editora) {
        try {
            String response = this.editoraService.save(editora);

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro interno ao salvar editora!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        try {
            Editora editoraEncontrada = this.editoraService.findById(id);

            return new ResponseEntity<>(editoraEncontrada, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro interno ao buscar editora!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping({"", "/"})
    public ResponseEntity<?> listAll(){
        try {
            List<Editora> todasEditoras = this.editoraService.listAll();

            return new ResponseEntity<>(todasEditoras, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro interno ao buscar editoras!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id){
        try {
            String resposta = this.editoraService.deleteById(id);

            return new ResponseEntity<String>(resposta, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<String>("Erro interno ao deletar editora!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody Editora editora){
        try {
            String response = this.editoraService.update(id, editora);

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro interno ao editar editora!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
