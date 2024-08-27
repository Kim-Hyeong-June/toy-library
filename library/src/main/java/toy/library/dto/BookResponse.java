package toy.library.dto;


import lombok.Getter;
import lombok.Setter;
import toy.library.domain.Book;

@Getter
@Setter
public class BookResponse {
    private String BookName;
    private String BookNumber;
    private String BookAuthor;

    public BookResponse(Book book) {
        BookName = book.getBookName();
        BookNumber = book.getBookNumber();
        BookAuthor = book.getBookAuthor();
    }
}
