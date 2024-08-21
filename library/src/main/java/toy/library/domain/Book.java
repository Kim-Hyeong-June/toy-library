package toy.library.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@NoArgsConstructor
@Getter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String BookName;

    private String BookAuthor;

    private String BookNumber;

    @Setter
    private boolean available = true;

    @OneToMany(mappedBy = "book")
    private List<Rental> rentalList = new ArrayList<>();

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
