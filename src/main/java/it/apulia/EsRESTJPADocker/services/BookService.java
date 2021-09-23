package it.apulia.EsRESTJPADocker.services;

import it.apulia.EsRESTJPADocker.model.Libro;

import java.util.List;

public interface BookService {

    List<Libro> getLibri();

    List<Libro> getLibriByAutore(String nomeAutore);

    List<Libro> getLibriByAnno(Integer annoPB);

    Libro getLibro(Long bookId);

    Libro getLibro(String autore, String titolo);

    void saveLibro(Libro libro);

    void updateLibro(Libro libro);

    void deleteLibro(String autore, String titolo);

    public List<Libro> findLibroContainingString (String stringa);
}
