package toy.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import toy.library.domain.Rental;

import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Long> {
    List<Rental> findByUserId(Long userId);
    List<Rental> findByBookId(Long bookId);
    List<Rental> findAll();
    @Query("SELECT r FROM Rental r JOIN FETCH r.user u JOIN FETCH r.book b")
    List<Rental> findAllWithUserAndBook();
}
