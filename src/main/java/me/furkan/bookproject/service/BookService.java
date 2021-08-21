package me.furkan.bookproject.service;

import lombok.extern.slf4j.Slf4j;
import me.furkan.bookproject.dto.BookDto;
import me.furkan.bookproject.dto.converter.BookDtoConverter;
import me.furkan.bookproject.exception.BookNotFoundException;
import me.furkan.bookproject.model.Book;
import me.furkan.bookproject.repository.BookRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class BookService {
    private final BookRepository bookRepository;
    private final BookDtoConverter bookDtoConverter;

    public BookService(BookRepository bookRepository, BookDtoConverter bookDtoConverter) {
        this.bookRepository = bookRepository;
        this.bookDtoConverter = bookDtoConverter;
    }

    public BookDto save(BookDto book) {
        final Book savedBook = bookRepository.save(bookDtoConverter.convertToEntity(book));
        log.info("Saved book named " + book.getName());
        return bookDtoConverter.convertToDto(savedBook);
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
    public void deleteById(long id) {
        bookRepository.deleteById(id);
    }

    @Transactional
    public BookDto updateBook(BookDto bookDto) {
        final Book book = bookRepository.save(bookDtoConverter.convertToEntity(bookDto));
        return bookDtoConverter.convertToDto(bookRepository.save(book));
    }




}
