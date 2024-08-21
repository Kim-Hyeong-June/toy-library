package toy.library.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime rentalDate;

    @Column(columnDefinition = "TIMESTAMP")
    @Setter
    private LocalDateTime returnDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @Builder
    public Rental(LocalDateTime rentalDate, User user, Book book) {
        this.rentalDate = rentalDate;
        this.user = user;
        this.book = book;
    }
}
