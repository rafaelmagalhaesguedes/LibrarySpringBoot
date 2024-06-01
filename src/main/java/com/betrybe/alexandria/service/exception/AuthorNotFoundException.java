package com.betrybe.alexandria.service.exception;

/**
 * The type Author not found exception.
 */
public class AuthorNotFoundException extends NotFoundException {

  /**
   * Instantiates a new Author not found exception.
   */
  public AuthorNotFoundException() {
    super("Pessoa autora não encontrada!");
  }
}
