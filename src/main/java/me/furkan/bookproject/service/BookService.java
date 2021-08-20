package me.furkan.bookproject.service;

import me.furkan.bookproject.repository.BookRepository;
import org.springframework.stereotype.Service;


@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


}
