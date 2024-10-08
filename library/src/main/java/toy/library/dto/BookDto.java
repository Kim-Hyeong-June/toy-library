package toy.library.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import toy.library.domain.Book;

@Getter
@Setter
public class BookDto {
    private String BookName;
    private String BookNumber;
    private String BookAuthor;
    
    public BookDto(String bookName, String bookNumber, String bookAuthor) {
        BookName = bookName;
        BookNumber = bookNumber;
        BookAuthor = bookAuthor;
    }

    public BookDto(Book book) {
        BookName = book.getBookName();
        BookNumber = book.getBookNumber();
        BookAuthor = book.getBookAuthor();
    }
}
