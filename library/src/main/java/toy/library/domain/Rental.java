package toy.library.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@ToString
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime rentalDate;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime returnDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;


    @Enumerated(EnumType.STRING)
    private RentalStatus rentalStatus;

    @Builder
    public Rental(LocalDateTime rentalDate, User user, Book book) {

        this.rentalDate = rentalDate;
        this.user = user;
        this.book = book;
        this.rentalStatus = RentalStatus.RENTING;
        user.getRentals().add(this);
        book.getRentals().add(this);
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
        this.rentalStatus = RentalStatus.COMPLETE;
    }
}
