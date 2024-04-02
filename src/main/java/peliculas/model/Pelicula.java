package peliculas.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pelicula")
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

// Getters & Setters
// /////
    private String titulo;
    private int anio;
    private String director;
    private String genero;
    private String sinopsis;

    public Long   getId()       {return id;}
    public String getTitulo()   {return titulo;}
    public int    getAnio()     {return anio;}
    public String getDirector() {return director;}
    public String getGenero()   {return genero;}
    public String getSinopsis() {return sinopsis;}

    public void setTitulo(String titulo)     {this.titulo = titulo;}
    public void setAnio(int anio)            {this.anio = anio;}
    public void setDirector(String director) {this.director = director;}
    public void setGenero(String genero)     {this.genero = genero;}
    public void setSinopsis(String sinopsis) {this.sinopsis = sinopsis;}
}
