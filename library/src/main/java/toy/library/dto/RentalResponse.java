package toy.library.dto;

import lombok.Getter;
import lombok.Setter;
import toy.library.domain.Book;
import toy.library.domain.Rental;
import toy.library.domain.User;

import java.time.LocalDateTime;

@Getter
@Setter
public class RentalResponse {
    private LocalDateTime rentalDate;
    private LocalDateTime returnDate;
    private String UserName;
    private String BookName;

    public RentalResponse(Rental rental) {
        rentalDate = rental.getRentalDate();
        returnDate = rental.getReturnDate();
        UserName = rental.getUser().getUsername();
        BookName = rental.getBook().getBookName();
    }
}
