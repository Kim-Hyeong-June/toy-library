package toy.library.dto;

import lombok.Getter;
import lombok.Setter;
import toy.library.domain.Rental;
import toy.library.domain.RentalStatus;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class RentalResponse {
    private LocalDateTime rentalDate;
    private LocalDateTime returnDate;
    private RentalStatus rentalStatus;

    public RentalResponse(Rental rental) {
        rentalDate = rental.getRentalDate();
        returnDate = rental.getReturnDate();
        rentalStatus = rental.getRentalStatus();
    }
}
