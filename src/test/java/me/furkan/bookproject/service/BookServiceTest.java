package me.furkan.bookproject.service;

import me.furkan.bookproject.TestEntity;
import me.furkan.bookproject.dto.BookDto;
import me.furkan.bookproject.dto.converter.BookDtoConverter;
import me.furkan.bookproject.exception.BookNotFoundException;
import me.furkan.bookproject.model.Book;
import me.furkan.bookproject.repository.elasticsearch.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BookServiceTest extends TestEntity {
    private BookRepository bookRepository;
    private BookService bookService;

    @BeforeEach
    void setUp() {
        ModelMapper modelMapper = new ModelMapper();

        BookDtoConverter bookDtoConverter = new BookDtoConverter(modelMapper);
        bookRepository = mock(BookRepository.class);
        bookService = new BookService(bookRepository, bookDtoConverter);
    }

    @Test
    void save() {
    }

    @Test
    void getBookById() {
        Book book = generateBook();
        BookDto bookDto = generateBookDto();
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));
        assertEquals(bookService.getBookById(1L), bookDto);
    }

    @Test
    void getBookById_WhenBookDoesNotExist_ThenReturnException() {
        when(bookRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(BookNotFoundException.class, () -> bookService.getBookById(1L));
    }

    @Test
    void getBookByName() {
        Book book = generateBook();
        BookDto bookDto = generateBookDto();
        when(bookRepository.findByName("test")).thenReturn(Optional.of(book));
        assertEquals(bookService.getBookByName("test"), bookDto);
    }

    @Test
    void getBookByName_WhenBookDoesNotExist_ThenReturnException() {
        when(bookRepository.findByName("test")).thenReturn(Optional.empty());

        assertThrows(BookNotFoundException.class, () -> bookService.getBookByName("test"));
    }

    @Test
    void getAll() {
        Book book = generateBook();
        BookDto bookDto = generateBookDto();
        List<Book> bookList = Collections.singletonList(book);
        List<BookDto> bookDtoList = Collections.singletonList(bookDto);

        when(bookRepository.findAll()).thenReturn(bookList);

        assertEquals(bookDtoList, bookService.getAll());
    }
}