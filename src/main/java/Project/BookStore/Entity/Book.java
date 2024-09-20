package Project.BookStore.Entity;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
    private List<Genres> genres;


}
