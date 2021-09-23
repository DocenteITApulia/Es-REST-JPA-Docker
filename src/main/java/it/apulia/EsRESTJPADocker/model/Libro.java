package it.apulia.EsRESTJPADocker.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table
@NoArgsConstructor //necessario in quanto se mancante dava un errore durante le richieste
public class Libro {

    @Id
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )
    Long bookId;
    String titolo;
    String autore;

    Integer anno;
    String link;

    public Libro(String titolo, String autore, Integer anno, String link) {
        this.titolo = titolo;
        this.autore = autore;
        this.anno = anno;
        this.link = link;
    }
}
