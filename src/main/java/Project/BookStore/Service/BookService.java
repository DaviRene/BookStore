package Project.BookStore.Service;

import Project.BookStore.Entity.Book;
import Project.BookStore.Repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> ListAll(){
        return bookRepository.findAll();
    }

    public Book findBookByName(String name){
        return bookRepository.findBookByName(name)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Book not found"));
    }

    public Book findBookByIsbn(String isbn){
        return bookRepository.findBookByISBN(isbn)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Book not found"));
    }

    public Book save(@RequestBody Book book){
        return bookRepository.save(book);
    }

    public void delete(String isbn){
        bookRepository.delete(findBookByIsbn(isbn));
    }
}
