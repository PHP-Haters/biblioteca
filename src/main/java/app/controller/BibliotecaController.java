package app.controller;

import app.model.Biblioteca;
import app.service.BibliotecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/biblioteca")
public class BibliotecaController {
    @Autowired
    private BibliotecaService bibliotecaService;

    // Post no endpoint "/biblioteca"
    @PostMapping
    public ResponseEntity<String> save(@RequestBody Biblioteca biblioteca) {
        try {
            String response = this.bibliotecaService.save(biblioteca);

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro interno ao salvar biblioteca!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // GetBibliotecaById no endpoint "/biblioteca/{id}"
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        try {
            Biblioteca bibliotecaEncontrada = this.bibliotecaService.findById(id);

            return new ResponseEntity<>(bibliotecaEncontrada, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro interno ao buscar biblioteca!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping({"", "/"})
    public ResponseEntity<?> listAll(){
        try {
            List<Biblioteca> todasBibliotecas = this.bibliotecaService.listAll();

            return new ResponseEntity<>(todasBibliotecas, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro interno ao buscar bibliotecas!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        try {
            String resposta = this.bibliotecaService.deleteById(id);

            return new ResponseEntity<String>(resposta, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<String>("Erro interno ao deletar biblioteca!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
