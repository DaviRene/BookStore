package Project.BookStore.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;


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


}
