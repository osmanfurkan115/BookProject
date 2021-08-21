package me.furkan.bookproject.controller;

import lombok.RequiredArgsConstructor;
import me.furkan.bookproject.dto.BookDto;
import me.furkan.bookproject.model.Book;
import me.furkan.bookproject.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping("/save")
    public ResponseEntity<BookDto> save(@Valid @RequestBody Book book) {
        return ResponseEntity.ok(bookService.save(book));
    }

    @GetMapping("/getBookById/{bookId}")
    public ResponseEntity<BookDto> getBookById(@PathVariable long bookId) {
        return ResponseEntity.ok(bookService.getBookById(bookId));
    }
    @GetMapping("/getBookByName/{bookName}")
    public ResponseEntity<BookDto> getBookByName(@PathVariable String bookName) {
        return ResponseEntity.ok(bookService.getBookByName(bookName));
    }

    @GetMapping("/getBooks")
    public ResponseEntity<List<BookDto>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAll());
    }
}
