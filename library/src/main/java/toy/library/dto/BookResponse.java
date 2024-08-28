package toy.library.dto;


import lombok.Getter;
import lombok.Setter;
import toy.library.domain.Book;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class BookResponse {
    private String BookName;
    private String BookNumber;
    private String BookAuthor;
    List<RentalResponse> rentals;

    public BookResponse(Book book) {
        BookName = book.getBookName();
        BookNumber = book.getBookNumber();
        BookAuthor = book.getBookAuthor();
        rentals = book.getRentals().stream()
                .map(o -> new RentalResponse(o))
                .collect(Collectors.toList());
    }
}
