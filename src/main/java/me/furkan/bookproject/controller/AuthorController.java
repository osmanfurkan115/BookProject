package me.furkan.bookproject.controller;

import lombok.RequiredArgsConstructor;
import me.furkan.bookproject.dto.AuthorDto;
import me.furkan.bookproject.model.Author;
import me.furkan.bookproject.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/author")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @PostMapping("/save")
    public ResponseEntity<AuthorDto> save(@Valid @RequestBody Author author) {
        return ResponseEntity.ok(authorService.save(author));
    }

    @GetMapping("/getAuthorById/{authorId}")
    public ResponseEntity<AuthorDto> getAuthorById(@PathVariable int authorId) {
        return ResponseEntity.ok(authorService.getAuthorById(authorId));
    }
    @GetMapping("/getAuthorByName/{authorName}")
    public ResponseEntity<AuthorDto> getAuthorByName(@PathVariable String authorName) {
        return ResponseEntity.ok(authorService.getAuthorByName(authorName));
    }

    @GetMapping("/getAuthors")
    public ResponseEntity<List<AuthorDto>> getAllAuthors() {
        return ResponseEntity.ok(authorService.getAll());
    }
}