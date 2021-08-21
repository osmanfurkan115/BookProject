package me.furkan.bookproject.service;

import me.furkan.bookproject.dto.BookDto;
import me.furkan.bookproject.dto.converter.BookDtoConverter;
import me.furkan.bookproject.exception.BookNotFoundException;
import me.furkan.bookproject.model.Book;
import me.furkan.bookproject.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class BookService {
    private final BookRepository bookRepository;
    private final BookDtoConverter bookDtoConverter;

    public BookService(BookRepository bookRepository, BookDtoConverter bookDtoConverter) {
        this.bookRepository = bookRepository;
        this.bookDtoConverter = bookDtoConverter;
    }

    public BookDto save(Book book) {
        return bookDtoConverter.convertToDto(bookRepository.save(book));
    }

    public BookDto getBookById(long id) {
        return bookDtoConverter.convertToDto(bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Couldn't find a book with id: " + id)));
    }

    public BookDto getBookByName(String name) {
        return bookDtoConverter.convertToDto(bookRepository.findByName(name).orElseThrow(() -> new BookNotFoundException("Couldn't find a book with name: " + name)));
    }

    public List<BookDto> getAll() {
        return bookRepository.findAll().stream().map(bookDtoConverter::convertToDto).collect(Collectors.toList());
    }




}
