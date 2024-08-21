package toy.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import toy.library.domain.Rental;

import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Long> {
    List<Rental> findByUserId(Long userId);
    List<Rental> findByBookId(Long bookId);
}
