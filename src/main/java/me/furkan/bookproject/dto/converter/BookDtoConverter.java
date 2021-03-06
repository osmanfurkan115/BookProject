package me.furkan.bookproject.dto.converter;

import me.furkan.bookproject.dto.BookDto;
import me.furkan.bookproject.model.Book;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BookDtoConverter implements Converter<Book, BookDto> {
    private final ModelMapper modelMapper;

    public BookDtoConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    @Override
    public BookDto convertToDto(Book entity) {
        return modelMapper.map(entity, BookDto.class);
    }

    @Override
    public Book convertToEntity(BookDto dto) {
        return modelMapper.map(dto, Book.class);
    }
}
