package com.betrybe.alexandria.service.exception;

/**
 * The type Book not found exception.
 */
public class BookDetailNotFoundException extends NotFoundException {

  /**
   * Instantiates a new Book not found exception.
   */
  public BookDetailNotFoundException() {
    super("Book detail not found.");
  }
}
