package Project.BookStore.Repository;

import Project.BookStore.Entity.Book;
import Project.BookStore.Entity.Genres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
    Optional<Book> findBookByName(String name);
    Optional<Book> findBookByISBN(String ISBN);
    Optional<List<Book>> findBooksByAuthor(String author);
    Optional<List<Book>> findBookByNameContaining(String name);
    Optional<List<Book>> findBookByGenres(Genres genre );
}
