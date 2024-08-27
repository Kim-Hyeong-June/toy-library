package toy.library.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import toy.library.domain.Book;
import toy.library.domain.Rental;
import toy.library.domain.User;
import toy.library.repository.BookRepository;
import toy.library.repository.UserRepository;

@SpringBootTest
@Transactional
class RentalServiceTest {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RentalService rentalService;

    @Test
    void RentAndRentBook(){
        // Given
        Book book = Book.builder().bookName("Test Book").build();
        User user = new User();

        bookRepository.save(book);
        userRepository.save(user);

        Rental rental = rentalService.rentBook(user.getId(), book.getId());
        Assertions.assertEquals(rental.getUser(), user);
        Assertions.assertEquals(rental.getBook(), book);

       Long l = rentalService.returnBook(rental.getId());
        Assertions.assertEquals(rental.getBook().isAvailable()  , true);
        Assertions.assertEquals(3L,rental.getId() ); //@PostConstruct


    }
}
