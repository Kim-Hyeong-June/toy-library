package toy.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import toy.library.domain.Book;
import toy.library.domain.Rental;
import toy.library.domain.User;
import toy.library.repository.BookRepository;
import toy.library.repository.RentalRepository;
import toy.library.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RentalService {
    private final RentalRepository rentalRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    @Autowired
    public RentalService(RentalRepository rentalRepository, BookRepository bookRepository, UserRepository userRepository) {
        this.rentalRepository = rentalRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    public Rental rentBook(Long userId , Long bookId){
        User user = userRepository.findById(userId).orElseThrow(() ->
                new RuntimeException("User not found"));

        Book book = bookRepository.findById(bookId).orElseThrow(() ->
                new RuntimeException("Book not found"));

        if(book.isAvailable()){
            book.setAvailable(false);
            Rental rental = Rental.builder().rentalDate(LocalDateTime.now()).book(book).user(user).build();
            return rentalRepository.save(rental);
        }
        else{
            throw new RuntimeException("Book is already rented");
        }
    }

    public Long returnBook(Long rentalId){
        Rental rental = rentalRepository.findById(rentalId)
                .orElseThrow(() -> new RuntimeException("Rental_Id Not Found"));
        rental.setReturnDate(LocalDateTime.now());
        Book book = rental.getBook();
        book.setAvailable(true);
        return rentalId;
    }

    public List<Rental> findRentalsByUser(Long userId){
        return rentalRepository.findByUserId(userId);
    }

    public List<Rental> findRentalsByBook(Long BookId){
        return rentalRepository.findByBookId(BookId);
    }
    public List<Rental> findRentalsAll(){
        return rentalRepository.findAll();
    }
}
