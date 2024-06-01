package com.betrybe.alexandria.controller.dto;

import com.betrybe.alexandria.entity.Book;

/**
 * The type Book creation dto.
 */
public record BookCreationDto(String title, String genre) {

  /**
   * To entity book.
   *
   * @return the book
   */
  public Book toEntity() {
    return new Book(title, genre);
  }
}
