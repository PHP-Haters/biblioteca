package app.controller;

import app.service.AutorService;
import app.model.Autor;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/autor")
public class AutorController {

    private final AutorService autorService;

    public AutorController(AutorService autorService) { this.autorService = autorService; }

    @GetMapping("/findAll")
    public ResponseEntity<List<Autor>> findAll() {
        try {
            var result = autorService.findAll();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Autor autor) {
        try {
            String result = this.autorService.save(autor);
            return new ResponseEntity<String>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<String>("Deu algo errado!", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Autor> delete(@PathVariable Integer id) {
        try {
            autorService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Autor> update(@PathVariable Integer id, @RequestBody Autor autorUpdate) {
        try {
            var result = autorService.update(id, autorUpdate);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}
