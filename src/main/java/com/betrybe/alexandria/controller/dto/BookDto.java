package com.betrybe.alexandria.controller.dto;

import com.betrybe.alexandria.entity.Author;
import com.betrybe.alexandria.entity.Book;
import java.util.List;

/**
 * The type Book dto.
 */
public record BookDto(
    Long id,
    String title,
    String genre,
    PublisherDto publisher,
    List<AuthorDto> authors) {

  /**
   * From entity book dto.
   *
   * @param book the book
   * @return the book dto
   */
  public static BookDto fromEntity(Book book) {
    PublisherDto publisherDto = book.getPublisher() != null ?
        PublisherDto.fromEntity(book.getPublisher()) : null;

    return new BookDto(
        book.getId(),
        book.getTitle(),
        book.getGenre(),
        publisherDto,
        book.getAuthors().stream() // Transforma a lista em uma Stream
            .map(AuthorDto::fromEntity)  // Mapeia os dados na através da AuthorDto
            .toList()  // Transforma o Stream em uma Lista
    );
  }
}
