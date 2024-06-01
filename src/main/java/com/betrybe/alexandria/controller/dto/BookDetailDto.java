package com.betrybe.alexandria.controller.dto;

import com.betrybe.alexandria.entity.BookDetail;

/**
 * The type Book detail dto.
 */
public record BookDetailDto(Long id, String summary, Integer pageCount, Integer year, String isbn) {

  /**
   * From entity book detail dto.
   *
   * @param bookDetail the book detail
   * @return the book detail dto
   */
  public static BookDetailDto fromEntity(BookDetail bookDetail) {
    return new BookDetailDto(
        bookDetail.getId(),
        bookDetail.getSummary(),
        bookDetail.getPageCount(),
        bookDetail.getYear(),
        bookDetail.getIsbn()
    );
  }
}
