package me.furkan.bookproject.dto.converter;

import me.furkan.bookproject.TestEntity;
import me.furkan.bookproject.dto.BookDto;
import me.furkan.bookproject.model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;


import static org.junit.jupiter.api.Assertions.*;

class BookDtoConverterTest extends TestEntity {

    private BookDtoConverter bookDtoConverter;

    @BeforeEach
    void setUp() {
        ModelMapper modelMapper = new ModelMapper();
        bookDtoConverter = new BookDtoConverter(modelMapper);
    }

    @Test
    void convertToDto() {
        Book book = generateBook();
        BookDto bookDto = generateBookDto();

        assertEquals(bookDtoConverter.convertToDto(book), bookDto);
    }

    @Test
    void convertToEntity() {
        Book book = generateBook();
        BookDto bookDto = generateBookDto();

        assertEquals(bookDtoConverter.convertToEntity(bookDto), book);

    }
}