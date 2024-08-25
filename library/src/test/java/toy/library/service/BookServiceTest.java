package toy.library.service;

import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import toy.library.domain.Book;
import toy.library.dto.BookDto;
import toy.library.repository.BookRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class BookServiceTest {

    @InjectMocks
    private BookService bookService;
    @Mock
    private BookRepository bookRepository;

    @Test
    void TestFindByBookIdSuccess() {
        // Given
        Long bookId = 1L;
        Book book = Book.builder().bookName("Test Book").build();
        BDDMockito.when(bookRepository.findById(bookId)).thenReturn(java.util.Optional.of(book));

        // When
        Book foundBook = bookService.findByBookId(bookId);

        // Then
        assertEquals("Test Book", foundBook.getBookName());
    }

    @Test
    void testSaveBook() {
        // Given
        BookDto bookDto = new BookDto("Test Author", "123444", "Harry");
        Book book = Book.builder()
                .bookAuthor(bookDto.getBookAuthor())
                .bookName(bookDto.getBookName())
                .bookNumber(bookDto.getBookNumber())
                .build();
        BDDMockito.when(bookRepository.save(any(Book.class))).thenReturn(book);

        // When
        Book savedBook = bookService.saveBook(bookDto);

        assertEquals(bookDto.getBookAuthor(), savedBook.getBookAuthor());
        assertEquals(bookDto.getBookName(), savedBook.getBookName());
        assertEquals(bookDto.getBookNumber(), savedBook.getBookNumber());
    }

    @Test
    void testUpdateBookSuccess() {
        // Given
        Long bookId = 1L;
        BookDto bookDto = new BookDto("Updated Book", "12343", "Curry");
        Book book = Book.builder().bookName("Original Book").build();
        BDDMockito.when(bookRepository.findById(bookId)).thenReturn(Optional.of(book));

        // When
        Long updatedBookId = bookService.update(bookId, bookDto);

        // Then
        assertEquals(bookId, updatedBookId);

        assertEquals("Updated Book", book.getBookName());
    }

    @Test
    void testUpdateBookFailure() {
        // Given
        Long bookId = 1L;
        BookDto bookDto = new BookDto("Updated Author", "123213", "candy");
        BDDMockito.when(bookRepository.findById(bookId)).thenReturn(Optional.empty());

        // When & Then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bookService.update(bookId, bookDto);
        });

        assertEquals("해당 ID 를 가진 객체를 찾을 수 없습니다 : 1", exception.getMessage());
    }

}
