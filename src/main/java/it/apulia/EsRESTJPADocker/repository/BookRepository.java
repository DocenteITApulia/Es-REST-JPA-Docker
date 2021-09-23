package it.apulia.EsRESTJPADocker.repository;

import it.apulia.EsRESTJPADocker.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference
@Repository
public interface BookRepository extends JpaRepository<Libro,Long> {

    Libro findLibroByAutoreAndTitolo(String autore,String titolo);

    List<Libro> findLibroByAutore(String autore);

    List<Libro> findLibroByAnno(Integer anno);

    @Query("SELECT l FROM Libro l where l.titolo LIKE %?1%")
    List<Libro> findLibrocontainingparoa(String parola);

    void deleteLibroByAutoreAndTitolo(String autore, String titolo);
}
