package Project.BookStore.Service;

import Project.BookStore.Entity.Book;
import Project.BookStore.Exceptions.BadRequestException;
import Project.BookStore.Repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> ListAll(){
        return bookRepository.findAll();
    }

    public Book findBookByName(String name){
        return bookRepository.findBookByName(name)
                .orElseThrow(() -> new BadRequestException("Book not found"));
    }

    public List<Book> findBookByNameContaining(String name){
        return bookRepository.findBookByNameContaining(name)
                .orElseThrow(() -> new BadRequestException("Books not Found"));
    }

    public List<Book> findBooksByAuthor(String author){
        return bookRepository.findBooksByAuthor(author)
                .orElseThrow(() -> new BadRequestException("Books not found"));
    }

    public Book findBookByIsbn(String isbn){
        return bookRepository.findBookByISBN(isbn)
                .orElseThrow(() -> new BadRequestException("Book not found"));
    }

    public Book save(@RequestBody Book book){
        return bookRepository.save(book);
    }

    public void delete(String isbn){
        bookRepository.delete(findBookByIsbn(isbn));
    }
}
