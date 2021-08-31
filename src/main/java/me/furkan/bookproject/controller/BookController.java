package me.furkan.bookproject.controller;

import lombok.RequiredArgsConstructor;
import me.furkan.bookproject.dto.BookDto;
import me.furkan.bookproject.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/book")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping("/save")
    public ResponseEntity<BookDto> save(@Valid @RequestBody BookDto book) {
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

    @GetMapping("/getBookByNameLike/{bookName}")
    public ResponseEntity<BookDto> getBookByNameLike(@PathVariable String bookName) {
        return ResponseEntity.ok(bookService.getBookByNameLike(bookName));
    }

    @GetMapping("/getBooks")
    public ResponseEntity<List<BookDto>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAll());
    }

    @PutMapping("/update")
    public ResponseEntity<BookDto> update(@Valid @RequestBody BookDto bookDto) {
        return ResponseEntity.ok(bookService.updateBook(bookDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        bookService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
