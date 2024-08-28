package toy.library.dto;

import lombok.Getter;
import lombok.Setter;
import toy.library.domain.Rental;
import toy.library.domain.RentalStatus;

import java.time.LocalDateTime;

@Getter
@Setter
public class RentalAllResponse {
    private LocalDateTime rentalDate;
    private LocalDateTime returnDate;
    private RentalStatus rentalStatus;
    private String userName;
    private String bookName;

    public RentalAllResponse(Rental rental) {
        rentalDate = rental.getRentalDate();
        returnDate = rental.getReturnDate();
        rentalStatus = rental.getRentalStatus();
        userName = rental.getUser().getUsername();
        bookName = rental.getBook().getBookName();
    }
}
