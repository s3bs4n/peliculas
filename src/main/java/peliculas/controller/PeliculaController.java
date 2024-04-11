package peliculas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import peliculas.model.Pelicula;
import peliculas.service.PeliculaService;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.apache.catalina.connector.Response;
import org.apache.logging.log4j.spi.ObjectThreadContextMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("/peliculas")
public class PeliculaController {


    private static final Logger log = LoggerFactory.getLogger(PeliculaController.class);


    @Autowired
    private PeliculaService peliculaService;

    @GetMapping
    public List<Pelicula> getAllPeliculas() {
        log.info("GET /peliculas");
        log.info("Retornando todas las peliculas");
        return peliculaService.getAllPeliculas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPeliculaById(@PathVariable Long id) {
        Optional<Pelicula> pelicula = peliculaService.getPeliculaById(id);

        if (pelicula.isEmpty()) {
            log.error("No pelicula con ID {}", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorRespose("No se encontro pelicula con ID {}" + id));
        }
        log.info("Estudiante encontrado con exito");
        return ResponseEntity.ok(pelicula);
    }

    @PostMapping
    public ResponseEntity<Object> createPelicula(@RequestBody Pelicula pelicula){
        Pelicula createdPelicula = peliculaService.createPelicula(pelicula);
        if (createdPelicula == null) {
            log.error("Error al crear la pelicula {}", pelicula);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorRespose("error al crear peliculaaaaaaaaaa"));
            
        }
        return ResponseEntity.ok(createdPelicula);
    }

    @PutMapping("/{id}")
    public Pelicula updatePelicula(@PathVariable Long id, @RequestBody Pelicula pelicula) {
        return peliculaService.updatePelicula(id, pelicula);
    }

    @DeleteMapping("/{id}")
    public void deletePelicula(@PathVariable Long id){
        peliculaService.deletePelicula(id);
    }

    static class ErrorRespose {
        private final String message;
        public ErrorRespose(String _message) {
            this.message = _message;
        }

        public String getMessage() {
            return message;
        }
    }
    
    


}

