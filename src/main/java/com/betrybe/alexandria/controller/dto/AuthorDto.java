package com.betrybe.alexandria.controller.dto;

import com.betrybe.alexandria.entity.Author;

/**
 * The type Author dto.
 */
public record AuthorDto(Long id, String name, String nationality) {

  /**
   * From entity author dto.
   *
   * @param author the author
   * @return the author dto
   */
  public static AuthorDto fromEntity(Author author) {
    return new AuthorDto(
        author.getId(),
        author.getName(),
        author.getNationality()
    );
  }
}
