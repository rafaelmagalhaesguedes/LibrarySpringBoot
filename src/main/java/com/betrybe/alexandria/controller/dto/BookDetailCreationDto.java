package com.betrybe.alexandria.controller.dto;

import com.betrybe.alexandria.entity.BookDetail;

/**
 * The type Book detail creation dto.
 */
public record BookDetailCreationDto(String summary, Integer pageCount, Integer year, String isbn) {

  /**
   * To entity book detail.
   *
   * @return the book detail
   */
  public BookDetail toEntity() {
    return new BookDetail(summary, pageCount, year, isbn);
  }
}
