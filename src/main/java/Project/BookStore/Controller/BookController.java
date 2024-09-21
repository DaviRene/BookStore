package Project.BookStore.Controller;

import Project.BookStore.Entity.Book;
import Project.BookStore.Entity.Genres;
import Project.BookStore.Service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "Books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;


    @GetMapping
    public ResponseEntity<List<Book>> BookList(){
        return ResponseEntity.ok(bookService.ListAll());
    }

    @GetMapping("/genres")
    public List<Genres> getGenres(){
        return List.of(Genres.values());
    }

    @GetMapping(path = "/name/{name}")
    public ResponseEntity<Book> findBookByName(@PathVariable String name){
        return ResponseEntity.ok(bookService.findBookByName(name));
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/search")
    public ResponseEntity<List<Book>> findBooksByNameContaining(@RequestParam String name){
        return ResponseEntity.ok(bookService.findBookByNameContaining(name));
    }

    @GetMapping(path = "/author/{author}")
    public ResponseEntity<List<Book>> findBookByAuthor(@PathVariable String author){
        return ResponseEntity.ok(bookService.findBooksByAuthor(author));
    }

    @GetMapping(path = "/{isbn}")
    public ResponseEntity<Book> findBookByIsbn(@PathVariable String isbn){
        return ResponseEntity.ok(bookService.findBookByIsbn(isbn));
    }

    @PostMapping
    public ResponseEntity<Book> save(@RequestBody Book book){
        return new ResponseEntity<>(bookService.save(book), HttpStatus.CREATED);
    }
    @DeleteMapping(path = "/{isbn}")
    public ResponseEntity<Void> delete(@PathVariable String isbn){
        bookService.delete(isbn);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/genres/{genre}")
    public ResponseEntity<List<Book>> findBookByGenres(@PathVariable Genres genre){
        return ResponseEntity.ok(bookService.findBooksByGenres(genre));
    }
}
