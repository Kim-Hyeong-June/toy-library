package toy.library.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDto {
    private Long id;
    private String BookName;
    private String BookNumber;
    private String BookAuthor;

    public BookDto(String bookName, String bookNumber, String bookAuthor) {
        BookName = bookName;
        BookNumber = bookNumber;
        BookAuthor = bookAuthor;
    }
}
