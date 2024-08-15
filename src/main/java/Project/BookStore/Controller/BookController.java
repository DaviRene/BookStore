package Project.BookStore.Controller;

import Project.BookStore.Entity.Book;
import Project.BookStore.Service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "Books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> BookList(){
        return ResponseEntity.ok(bookService.ListAll());
    }


    @GetMapping(path = "/{name}")
    public ResponseEntity<Book> findBookByName(@PathVariable String name){
        return ResponseEntity.ok(bookService.findBookByName(name));
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
}
