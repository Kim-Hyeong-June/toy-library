package toy.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import toy.library.domain.Book;
import toy.library.dto.BookDto;
import toy.library.dto.BookResponse;
import toy.library.service.BookService;
import toy.library.service.RentalService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/bookList")
    public List<BookResponse> BookList() {
        List<Book> books = bookService.bookList();
        List<BookResponse> book = books.stream().map(o -> new BookResponse(o))
                .collect(Collectors.toList());
        return book;
    }
}
