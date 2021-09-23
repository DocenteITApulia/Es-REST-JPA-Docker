package it.apulia.EsRESTJPADocker.services;

import it.apulia.EsRESTJPADocker.model.Libro;
import it.apulia.EsRESTJPADocker.myexceptions.MyNotFoundExcp;
import it.apulia.EsRESTJPADocker.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public Libro getLibro(Long bookId){
        return bookRepository.findById(bookId).get();
    }
    @Override
    public List<Libro> getLibri() {
        return bookRepository.findAll();
    }

    @Override
    public List<Libro> getLibriByAutore(String nomeAutore) {

        List<Libro> temp = bookRepository.findLibroByAutore(nomeAutore);
        if(temp.isEmpty())
            throw new MyNotFoundExcp("L'autore non è presente all'interno del db");

        return temp;
    }

    @Override
    public List<Libro> getLibriByAnno(Integer annoPB) {

        return bookRepository.findLibroByAnno(annoPB);
    }

    @Override
    public Libro getLibro(String autore, String titolo) {

        return bookRepository.findLibroByAutoreAndTitolo(autore,titolo);
    }

    @Override
    public void saveLibro(Libro libro) {
        bookRepository.save(libro);
    }

    @Override
    @Transactional
    public void updateLibro(Libro libro){
        Libro temp = bookRepository.getById(libro.getBookId());
        temp.setTitolo(libro.getTitolo());
        temp.setAutore(libro.getAutore());
        temp.setAnno(libro.getAnno());
        temp.setLink(libro.getLink());

    }

    @Override
    public void deleteLibro(String autore, String titolo) {
        bookRepository.deleteLibroByAutoreAndTitolo(autore,titolo);
    }

    @Override
    public List<Libro> findLibroContainingString (String stringa){
        return bookRepository.findLibrocontainingparoa(stringa);
    }
}
