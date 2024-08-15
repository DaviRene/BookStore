package Project.BookStore.Repository;

import Project.BookStore.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
    Optional<Book> findBookByName(String name);
    Optional<Book> findBookByISBN(String ISBN);
}
