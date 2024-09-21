package Project.BookStore.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;


@Data
@Builder
@Component
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {
    private String name;
    @Id
    private String ISBN;
    private String author;
    private String publisher;
    private Date publishDate;
    @ElementCollection
    @CollectionTable(name = "Bookgenres")
    @Enumerated(EnumType.STRING)
    private List<Genres> genres;
}
