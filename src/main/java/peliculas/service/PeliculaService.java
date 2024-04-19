package peliculas.service;

import peliculas.model.Pelicula;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

public interface PeliculaService {

    List<Pelicula> getAllPeliculas();
    Optional<Pelicula> getPeliculaById(Long id);    

    Pelicula createPelicula(Pelicula pelicula);
    Pelicula updatePelicula(Long id, Pelicula pelicula);
    void deletePelicula(Long id);



}
