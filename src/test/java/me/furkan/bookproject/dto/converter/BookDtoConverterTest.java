package me.furkan.bookproject.dto.converter;

import me.furkan.bookproject.dto.BookDto;
import me.furkan.bookproject.model.Author;
import me.furkan.bookproject.model.Book;
import me.furkan.bookproject.model.BookType;
import me.furkan.bookproject.service.AuthorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BookDtoConverterTest {

    private BookDtoConverter bookDtoConverter;
    private ModelMapper modelMapper;
    private AuthorService authorService;

    @BeforeEach
    void setUp() {
        modelMapper = new ModelMapper();
        authorService = mock(AuthorService.class);
        bookDtoConverter = new BookDtoConverter(modelMapper, authorService);
    }

    @Test
    void convertToDto() {
        final Author test = new Author(1, "test", null);
        Book book = new Book(1L, test, "name" , "description", BookType.ADVENTURE, 1,1,2000, LocalDateTime.now());
        BookDto bookDto = new BookDto(book.getId(), book.getName(), book.getDescription(), book.getType(), book.getAuthor().getName(), book.getRateAmount(), book.getPageAmount(), book.getPublishingYear(), book.getCreatedTime());

        assertEquals(bookDtoConverter.convertToDto(book), bookDto);
    }

    @Test
    void convertToEntity() {
        final Author author = new Author(1, "test", null);
        BookDto bookDto = new BookDto(1L, "test", "description", BookType.ADVENTURE, author.getName(), 1,1,2000,LocalDateTime.now());
        Book book = new Book(bookDto.getId(),author, bookDto.getName(), bookDto.getDescription(), bookDto.getType(), bookDto.getRateAmount(), bookDto.getPageAmount(), bookDto.getPublishingYear(), bookDto.getCreatedTime());
        when(authorService.getAuthorByName(author.getName())).thenReturn(author);

        assertEquals(bookDtoConverter.convertToEntity(bookDto), book);

    }
}