package toy.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import toy.library.domain.Book;
import toy.library.service.BookService;
import toy.library.service.RentalService;

import java.util.List;

@Controller
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/bookList")
    public String BookList(Model model){
        List<Book> books = bookService.bookList();
        model.addAttribute("books", books);
        return "books/bookList";
    }

    @GetMapping("/bookAuthorList")
    public String BookAuthorList(Model model){
        List<Book> books = bookService.bookList();
        model.addAttribute("books", books);
        return "books/AuthorList";
    }
}
