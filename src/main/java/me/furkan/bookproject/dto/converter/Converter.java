package me.furkan.bookproject.dto.converter;

public interface Converter<E, D> {
    D convertToDto(E entity);
    E convertToEntity(D dto);
}
