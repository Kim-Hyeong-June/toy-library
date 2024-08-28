package toy.library.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@NoArgsConstructor
@Getter
//@ToString
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String BookName;

    private String BookAuthor;

    private String BookNumber;

    @Setter
    @Getter
    private boolean available = true;

    @OneToMany(mappedBy = "book")
    private List<Rental> rentals = new ArrayList<>();

    @Builder
    public Book(String bookName, String bookAuthor, String bookNumber) {
        BookName = bookName;
        BookAuthor = bookAuthor;
        BookNumber = bookNumber;
    }

    public void update(String bookName, String bookAuthor, String bookNumber) {
        this.BookName = bookName;
        this.BookAuthor = bookAuthor;
        this.BookNumber = bookNumber;
    }
}
