package toy.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import toy.library.domain.Book;
import toy.library.dto.BookDto;
import toy.library.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book findByBookId(Long id){
        return bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID 를 가진 객체를 찾을 수 없습니다 : " + id));
    }
    public Book saveBook(BookDto bookDto) {
        Book book = Book.builder()
                .bookAuthor(bookDto.getBookAuthor())
                .bookName(bookDto.getBookName())
                .bookNumber(bookDto.getBookNumber()).build();

        bookRepository.save(book);
        return book;
    }

    public Long update(Long id, BookDto bookDto) {
        Book book = findByBookId(id);

        book.update(bookDto.getBookName(), bookDto.getBookAuthor(), bookDto.getBookNumber());
        return id;
    }

    public Long delete(Long id) {
        Book book = findByBookId(id);
        bookRepository.delete(book);
        return id;
    }

    public List<Book> bookList(){
        List<Book> books = bookRepository.findAll();
        return books;
    }
}
