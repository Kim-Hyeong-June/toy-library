package toy.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import toy.library.domain.Book;


public interface BookRepository extends JpaRepository<Book, Long> {

}
