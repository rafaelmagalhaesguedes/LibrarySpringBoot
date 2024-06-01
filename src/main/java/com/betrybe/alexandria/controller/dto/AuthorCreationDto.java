package com.betrybe.alexandria.controller.dto;

import com.betrybe.alexandria.entity.Author;

/**
 * The type Author creation dto.
 */
public record AuthorCreationDto(String name, String nationality) {

  /**
   * To entity author.
   *
   * @return the author
   */
  public Author toEntity() {
    return new Author(name, nationality);
  }
}
