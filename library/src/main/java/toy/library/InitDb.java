package toy.library;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import toy.library.domain.Book;
import toy.library.domain.Rental;
import toy.library.domain.User;
import toy.library.dto.BookDto;
import toy.library.repository.UserRepository;
import toy.library.service.BookService;
import toy.library.service.RentalService;
import toy.library.service.UserService;

@Component
@RequiredArgsConstructor
public class InitDb {
    private final InitService initService;
    private final UserRepository userRepository;

    @PostConstruct
    public void init() {
        initService.dbInit1();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {

        private final BookService bookService;

        private final RentalService rentalService;

        private final UserService userService;
        public void dbInit1(){
            BookDto bookDto = new BookDto("Harry Potter1", "123445", "Kim Potter");
            Book book1 = bookService.saveBook(bookDto);

            BookDto bookDto2 = new BookDto("Harry Potter2", "124445", "Kim Potter");
            Book book2 =bookService.saveBook(bookDto2);

            BookDto bookDto3 = new BookDto("Harry Potter3", "129445", "Kim Potter");
            Book book3 =bookService.saveBook(bookDto3);

            User user = userService.createUser("kim", "12345");

            Rental rental1 = rentalService.rentBook(user.getId(), book1.getId());
            Rental rental2 = rentalService.rentBook(user.getId(), book2.getId());

        }
    }
}
